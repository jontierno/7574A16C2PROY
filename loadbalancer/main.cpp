#include <iostream>
#include <stdlib.h>
#include "string"
#include "vector"
#include <stdio.h>
#include <cstring>
#include <fstream>
#include <algorithm>
using namespace std;

#define STATICS_FILE "/home/load.db"
#define WORKERS_FILE "/home/workers.db"

string handleCrearCuenta(int nro) {
    return "";
}


string handleConsultarSaldo(int nro) {
    return "";
}


string handleDepositar(int nro, int cant) {
return "";
}

string handleRetirar(int nro, int cant) {

return "";
}


string handleMovimientos(int nro) {

return "";
}




vector<string> split(const string str, const string& delim){
    vector<string> tokens;
    size_t prev = 0, pos = 0;
    
    do
    {
        pos = str.find(delim, prev);
        if (pos == string::npos) pos = str.length();
        string token = str.substr(prev, pos-prev);
        if (!token.empty()) {
            tokens.push_back(token);
        }
        prev = pos + delim.length();
    }
    while (pos < str.length() && prev < str.length());
    return tokens;
}



string determineLocation(ifstream & ls, ifstream & ws) {
    string line;
    string body;
    string header;


    float freem;
    float load;
    float minload = 3000; 
    string idSel = ";;;";
    string id;
    string urlSel;
    vector<string> v1;
    vector<string> workers;
    vector<string> urlworkers;
    std::vector<string>::iterator it;

    while (getline (ws,line) ) {
        v1 = split(line, "=");
        workers.push_back(v1[0]);
        urlworkers.push_back(v1[1]);
    }

    while ( getline (ls,line) ) {
        //primer spliteo, para sacar el cuerpo y el header;
        v1 = split(line, " ");        
        header = v1[0];
        body = v1[1];
        //obtengo la carga de cpu y la memoria
        v1 = split(body, ";");
        freem = stof(v1[0]);
        load = stof(v1[1]);
        //si tengo cierta memoria libre y la carga es menor
        if(freem > 1000 && minload >= load) {
            v1 = split(header, "/");
            // busco la posicion de worker
            id = v1[1];
            it = find(workers.begin(), workers.end(), id);
            int pos = it - workers.begin();
            //si hay un worker tengo a mi destino
            if(pos < workers.size()) {
                minload = load;
                idSel = v1[1];
                urlSel = urlworkers[pos];
            }
        }
    }

    if(idSel == ";;;" ) {
        return "";
    }

    return urlSel;

}

void printError(string msg) {
    printf("Status: 500 Internal Server Error\n") ;
    cout << "Content-type:text/html\n\n";  
    cout << "<html>\n";
    cout << "<head>\n";
    cout << "</head>\n";
    cout << "<body>\n";
    cout << "<h1>" << msg <<"</h1> \n";
    cout << "</body>\n";
    cout << "</html>\n";
}

int  main (int argc, char *argv[])
{
    ifstream statsFile(string(STATICS_FILE));
    if (!statsFile.good()){
        printError("No se encuentra el archivo de stats");
    } else {
        ifstream workersFile(string(WORKERS_FILE));
        if(!workersFile.good()){
            statsFile.close();
            printError("No se encuentra el archivo de workers");
        } else {        
            string location = determineLocation(statsFile, workersFile);
            statsFile.close();
            workersFile.close();
            if(location.length() > 0) {
                    cout << "status: 302 Found\n";
                    cout << "Location: http://" << location<< "\n\n";
            } else {
                printError("No se pudo determinar el worker");
            }
        }
    }   


    return 0;
}
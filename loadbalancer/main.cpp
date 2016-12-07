#include <iostream>
#include <stdlib.h>
#include "string"
#include "vector"
#include <stdio.h>
#include <cstring>

using namespace std;

#define STATICS_FILE "statics.db"
#define WORKERS_FILE "workers.db"

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

vector<int> parseOperation (string str) {
    vector<int> numbers;
    vector <string> spl = split(str, ";");
    int n;
    for (vector<string>::iterator it = spl.begin(); it != spl.end(); ++it) {
            sscanf((*it).c_str() , "%d", &n);
            numbers.push_back(n);
    }
    return numbers;
}

int  main (int argc, char *argv[])
{
    char * query  = getenv("QUERY_STRING");
    string method(getenv("REQUEST_METHOD"));
    string script(getenv("SCRIPT_NAME"));
    printf("Content-type: application/json\n");

    vector<string> sp = split(script, "/");
    string op = sp[sp.size()-1];
    
    int error = 1;
    string result;


  
    ifstream statsFile(STATICS_FILE);
    if (!statsFile.good()){
        printf("Status: 500 Internal Server Error\n\n") ;
    } else {
        ifstream workersFile(WORKERS_FILE);
        if(!workersFile.good()){
            statsFile.close();
            printf("Status: 500 Internal Server Error\n\n") ;
        } else {
            printf("HTTP/1.1 302 Found\n\n");
            string location = determineLocation(statsFile, workersFile);
            printf("Location: http://%s", location);
        }
    }   


    return 0;
}
#include <iostream>
#include <stdlib.h>
#include "constants.h"

#include "string"
#include "vector"
#include <stdio.h>
#include <cstring>

using namespace std;


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
    if (op == "cuenta") {

        if(method == "GET" && query != NULL) {
            int numero;
            sscanf(query , "%d", &numero);
            result = handleConsultarSaldo(numero);
            error = 0;
        }
       if(method == "POST") {
            int body;
            cin >> body;
            result = handleCrearCuenta(body);
            error = 0;
        }
        
    }

    if (op == "movimientos") {
        if(method == "GET" && query != NULL) {
            int numero;
            sscanf(query , "%d", &numero);
            result = handleMovimientos(numero);
            error = 0;
        }
    }

    if (op == "deposito") {
        if(method == "PUT") {
            string body;
            cin >> body;
            vector<int> values = parseOperation(body);
            if(values.size() == 2){
                result = handleDepositar(values[0], values[1]);
                error = 0;
            }
        }
    }

    if (op == "extraccion") {
        if(method == "PUT") {
            string body;
            cin >> body;
            vector<int> values = parseOperation(body);
            if(values.size() == 2){
                result = handleRetirar(values[0], values[1]);
                error = 0;
            }
        }
    }


    if(error) 
        printf("Status: 400 Bad Request\n\n") ;
    else printf("Status: 200 OK\n\n");
    if(result.length() > 0) {
        printf("%s\n", result.c_str());    
    }
    
    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#define QUERY_PAR_MAX 20
#define PROTOCOL_MAX 20
#define HOSTNAME_MAX 50
#define DIR_MAX 100
#define FILENAME_MAX 50
#define MAX_QUERIES 50

char URL[] = "https://www.google.bg/?gfe_rd=cr&ei=pwEFWP79AuOX8QfW34HACQ";
void url_parse();
struct QUERY_PARAMETERS
{
    char name[QUERY_PAR_MAX];
    char value[QUERY_PAR_MAX];
};
struct URL_DATA
{
    char protocol[PROTOCOL_MAX];
    char hostname[HOSTNAME_MAX];
    char dir[DIR_MAX];
    char file_name[FILENAME_MAX];
    struct QUERY_PARAMETERS params[MAX_QUERIES];
}url;
int main()
{
    url_parse();
    puts(url.hostname);
    puts(url.protocol);
    puts(url.dir);
    puts(url.file_name);
    puts(url.params[1].value);
    puts(url.params[1].name);

    return 0;
}
void url_parse()
{
    char *full_dir = (char*)calloc(DIR_MAX, sizeof(char));
    int url_position, i, j, index_for_query_params;
    for(url_position = j = 0; URL[url_position] != ':'; url_position++, j++){
        url.protocol[j] = URL[url_position];
    }
    url_position += 3;
    for(j = 0;URL[url_position] != '/'; url_position++, j++){
        url.hostname[j] = URL[url_position];
    }
    for(j = 0;URL[url_position] != '?'; url_position++, j++){
        full_dir[j] = URL[url_position];
    }
    while(URL[url_position] != '/'){
        url_position--;
    }
    url_position++;
    for(j = 0;URL[url_position] != '?'; url_position++, j++){
        url.file_name[j] = URL[url_position];
    }
    for(i = 0; i < strlen(full_dir) - strlen(url.file_name); i++){
        url.dir[i] = full_dir[i];
    }
    while(URL[url_position] != '?'){
        url_position++;
    }
    url_position++;
    index_for_query_params = 0;
    while(URL[url_position] != '\0'){
        i = 0;
        while(URL[url_position] != '='){
            url.params[index_for_query_params].name[i] = URL[url_position];
            i++;
            url_position++;
        }
        i = 0;
        url_position++;
        while(URL[url_position] != ',' && URL[url_position] != '\0'){
            url.params[index_for_query_params].value[i] = URL[url_position];
            i++;
            url_position++;
        }
        url_position++;
        index_for_query_params++;
    }

}

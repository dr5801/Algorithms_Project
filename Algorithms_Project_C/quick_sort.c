/**
 * @Author Drew Rife
 *
 * This program uses quick-sort to sort the lists of randomized data
 *
 */

#include <stdio.h>

#define NUM_LISTS 3
#define FILES_PER_LIST 30
#define NUM_FILES 90

#define SMALL_AMOUNT 10000
#define MEDIUM_AMOUNT 100000
#define LARGE_AMOUNT 1000000

typedef enum {SMALL , MEDIUM, LARGE} lists;


void open_files(int associated_list);
void begin_sort(FILE *file);

int main(void)
{
    const char *directories[3];
    directories[0] = "../RandomData_Generation/text_files/small_list/small_random_";
    directories[1] = "../RandomData_Generation/text_files/medium_list/medium_random_";
    directories[2] = "../RandomData_Generation/text_files/large_list/large_random_";

    FILE *files[NUM_FILES];
    int lists;
//    for(lists = 1; lists <= NUM_LISTS; lists++)
//    {
//        open_files(lists);
//        int file_number;
//        for(file_number = 1; file_number <= FILES_PER_LIST; file_number++)
//        {
//            char file_name[200];
//            sprintf(filename, "%s%d.txt", file_names[i]);
//    
//            /* the file exists and is accessible */
//            if ( access(file_name, F_OK) != -1 )
//            {
//
//            }
//        }
//    }

}

void open_files(int associated_list)
{
}

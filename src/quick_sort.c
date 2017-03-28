/**
 * @Author Drew Rife
 *
 * This program uses quick-sort to sort the lists of randomized data
 *
 */

#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define NUM_LISTS 3
#define FILES_PER_LIST 30
#define NUM_FILES 90

#define SMALL_AMOUNT 10000
#define MEDIUM_AMOUNT 100000
#define LARGE_AMOUNT 1000000

void populate_list_of_dirs();
void read_data_into_arrays();

typedef enum {SMALL , MEDIUM, LARGE} List;

typedef char * string;

int small_unsorted_array[SMALL_AMOUNT];
int small_sorted_smallestLargest[SMALL_AMOUNT];
int small_sorted_largestSmallest[SMALL_AMOUNT];

int medium_unsorted_array[MEDIUM_AMOUNT];
int medium_sorted_smallestLargest[MEDIUM_AMOUNT];
int medium_sorted_largestSmallest[MEDIUM_AMOUNT];

int large_unsorted_array[LARGE_AMOUNT];
int large_sorted_smallestLargest[LARGE_AMOUNT];
int large_sorted_largestSmallest[LARGE_AMOUNT];


string list_of_dirs[9];

int main(void)
{
    populate_list_of_dirs();
    read_data_into_arrays();
    return 0;        
}

void read_data_into_arrays()
{
    int directory;
    string file_prefixes[2] = {"unsorted_", "sorted_"};
    for(directory = 0; directory < (sizeof(list_of_dirs)/sizeof(string)); directory++)
    {
        /* set string file equal to directory and concatenate '/' onto it */
        
        /* should be 30 files per directory */
        int file_number;
        for(file_number = 1; file_number <= FILES_PER_LIST; file_number++)
        {
            string snumber = (string) malloc(sizeof(string) * 6);
            snprintf(snumber, 2, file_number);
            strcat(snumber, ".txt");
            printf("%s\n", snumber);

            int length = strlen(list_of_dirs[directory]) + strlen(snumber) + 1;
            string file = malloc(length); 
            strcpy(file, list_of_dirs[directory]);
            strcat(file, snumber);
            
            free(snumber);
            free(file);
        }
    }
}

/**
 * populates the list of dirs to the text files 
 */
void populate_list_of_dirs()
{
    list_of_dirs[0] = "../text_files/small_list/unsorted/unsorted_";
    list_of_dirs[1] = "../text_files/small_list/sorted_smallest_largest/sorted_";
    list_of_dirs[2] = "../text_files/small_list/sorted_largest_smallest/sorted_";
    list_of_dirs[3] = "../text_files/medium_list/unsorted/unsorted_";
    list_of_dirs[4] = "../text_files/medium_list/sorted_smallest_largest/sorted_";
    list_of_dirs[5] = "../text_files/medium_list/sorted_largest_smallest/sorted_";
    list_of_dirs[6] = "../text_files/large_list/unsorted/unsorted_";
    list_of_dirs[7] = "../text_files/large_list/sorted_smallest_largest/sorted_";
    list_of_dirs[8] = "../text_files/large_list/sorted_largest_smallest/sorted_";
}

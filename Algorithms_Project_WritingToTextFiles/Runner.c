/*
 * Runner.c
 *
 *  Created on: Mar 20, 2017
 *      Author: drew
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <unistd.h>

#define NUM_FILES 30
#define MIN_VALUE 0
#define MAX_VALUE 9999
#define SMALL_AMOUNT 10000
#define MEDIUM_AMOUNT 100000
#define LARGE_AMOUNT 1000000

void generate_rand_numbers(FILE *file, int amount_to_generate);

/**
 * create the random text files
 */
int main(void)
{
	const char *file_names[3];
	file_names[0] = "text_files/small_list/small_random_";
	file_names[1] = "text_files/medium_list/medium_random_";
	file_names[2] = "text_files/large_list/large_random_";

	FILE *files[NUM_FILES];
	srand((unsigned)time(0));

	int lists;
	for(lists = 0; lists < 3; lists++)
	{
		int i;
		for(i = 1; i <= NUM_FILES; i++)
		{
			char filename[100];
			sprintf(filename, "%s%d.txt", file_names[lists],i);

			/* if file already exists remove it */
			if( access(filename, F_OK) != -1)
			{
				int ret = remove(filename);

			}

			files[i] = fopen(filename, "w");

			switch(lists)
			{
			case 0:
				printf("Generating %d random numbers between [%d, %d] for %s ...\n", SMALL_AMOUNT, MIN_VALUE, MAX_VALUE, filename);
				generate_rand_numbers(files[i], SMALL_AMOUNT);
				break;
			case 1:
				printf("Generating %d random numbers between [%d, %d] for %s ...\n", MEDIUM_AMOUNT, MIN_VALUE, MAX_VALUE, filename);
				generate_rand_numbers(files[i], MEDIUM_AMOUNT);
				break;
			case 2:
				printf("Generating %d random numbers between [%d, %d] for %s ...\n", LARGE_AMOUNT, MIN_VALUE, MAX_VALUE, filename);
				generate_rand_numbers(files[i], LARGE_AMOUNT);
				break;
			}

			fclose(files[i]);
		}
	}

	printf("\nDONE\n");
	return 0;
}

/**
 * generates random numbers for the file [MIN_VALUE, MAX_VALUE] for the amount_to_generate
 *
 * inputs are space delimited
 */
void generate_rand_numbers(FILE *file, int amount_to_generate)
{
	int i;
	for(i = 0; i < amount_to_generate; i++)
	{
		unsigned int result = rand() % (MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
		fprintf(file, "%d ", result);
	}
}


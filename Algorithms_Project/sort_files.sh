#sorts the random unsorted files 
#!bin/bash

RED='\e[1;32m%s\e[0m\n'
GREEN='\e[1;31m%s\e[0m\n'

# useful directories
TEXT_DIR="./text_files"
SMALL_LIST="small_list"
MEDIUM_LIST="medium_list"
LARGE_LIST="large_list"
UNSORTED="unsorted/"
SORTED_S_TO_L="sorted_smallest_largest/"
SORTED_L_TO_S="sorted_largest_smallest/"

FIRST_LEVEL_DIR="$SMALL_LIST $MEDIUM_LIST $LARGE_LIST"
SECOND_LEVEL_DIR="$UNSORTED $SORTED_S_TO_L $SORTED_L_TO_S"

# useful path to the unsorted files
SMALL_PATH=$TEXT_DIR$SMALL_LIST$UNSORTED 
MEDIUM_PATH=$TEXT_DIR$MEDIUM_LIST$UNSORTED
LARGE_PATH=$TEXT_DIR$MEDIUM_LIST$UNSORTED 

# goes back to base directory of where this file is located 
backToBase="cd ../../../"

# quick way to get all text files for sorting the random ones in each list directory
allFiles="*.txt"

#searches for directories
function searchForDirectories() 
{
    #make sure the text directory exists
    initialCheckIfExist $TEXT_DIR

    for DIRNAME in ${FIRST_LEVEL_DIR}; do
       initialCheckIfExist $TEXT_DIR/$DIRNAME
       
       for DIRNAME2 in ${SECOND_LEVEL_DIR}; do
           initialCheckIfExist $TEXT_DIR/$DIRNAME/$DIRNAME2 
       done 
    done
}

#checks to see if the directory exists
function initialCheckIfExist() {
    directory=$1
    printf "Checking $directory/ ... "
    
    if [ -d $directory/ ]
    then 
        printf "$GREEN\n" " Exists " 
    else 
        printf "$RED" " Doesn't exist "
        createDirectory $directory
    fi 
}

#creates the directory if it doesn't exist
function createDirectory() {
    printf "Creating $1/ ... "
    
    #make the directory
    mkdir "$1/"

    #check to see if the folder has been created 
    if [ -d $directory/ ]
    then 
        printf "$GREEN\n" " OK "
    else 
        printf "$RED\n" " THERE WAS AN ERROR CREATING DIRECTORY "
    fi
}

# sorts the unsorted random data and puts them into their respective sorted directory
function sortSmallList {
    cd $SMALL_PATH
    for file in $allFiles; do 
        sort -n $file > ../$SORTED_S_TO_L/sorted_$file 
        sort -nr $file > ../$SORTED_L_TO_S/sorted_$file 
    done 
}

searchForDirectories
#sortSmallList

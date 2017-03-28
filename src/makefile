default: quick_sort

quick_sort.o: quick_sort.c
	gcc -c -Wall quick_sort.c -o quick_sort.o

Runner: Runner.o
	gcc quick_sort.o -o quick_sort

clean:
	-rm -f quick_sort.o quick_sort

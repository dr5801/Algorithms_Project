default: Runner

Runner.o: Runner.c
	gcc -c -Wall Runner.c -o Runner.o

Runner: Runner.o
	gcc Runner.o -o Runner

clean:
	-rm -f Runner.o Runner

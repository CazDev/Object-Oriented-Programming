# The mole bug: Main thread sleep
	The mole bug is caused by a Thread.sleep() call within the impediments.jar file,
	specifically mole.class inside the method moveAtOwnSpeed() which contains a 2000ms sleep
	causing the program's main running thread to sleep (freeze) for 2 seconds. I found this 
	by decompiling the .class files and looking at the method that is called when the mole 
	moves (moveAtOwnSpeed).
	
# The pathfinding bug: Race condition
	The pathfinder bug is caused by concurrently running threads that are not thread safe.
	This means threads are running at the same time and accessing the same methods which causes problems.
	I found this is the problem because this only happens when there is threads concurrently
	running and there is no thread safe locking or scheduling.
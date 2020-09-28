#Mole solution
	After finding the Thread.sleep() call in moveAtOwnSpeed() as explained in BUGS.md
	I realised that this thread.sleep call can not be changed in the impediments.jar file
	therefore I had to make the change where moveAtOwnSpeed() is called in ImpAdapter.java.
	I have made this call run in a new thread which means the main thread will not stop
	but the new thread will stop instead when the mole wants to move.
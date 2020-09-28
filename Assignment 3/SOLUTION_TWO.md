#Pathfinding solution
	The pathfinder bug is caused by concurrently running threads that are not thread safe
	as explained in BUGS.md. I have utilised java.util.concurrent.locks to create a lock.
	This lock can be used to prevent access to resources while the resources are being used 
	by a single thread. This means that threads can run at the same time but are prevented from 
	overwriting values which was the cause of this bug.
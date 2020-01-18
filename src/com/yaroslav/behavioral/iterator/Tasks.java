package com.yaroslav.behavioral.iterator;

public class Tasks implements Container {
	private String [] tasks = {"Plant a house", "Build a tree", "Grow up son"};

	@Override
	public Iterator getIterator() {	
		return new TaskIterator();
	}
	
	private class TaskIterator implements Iterator{
		private int index = 0; 
		@Override
		public boolean hasNext() {
			if (index < tasks.length)
				return true;
			return false;
		}

		@Override
		public Object next() {
			return tasks[index++];
		}
		
	}
}

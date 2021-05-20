class Main {
	public static void main(String[] args) {
	int[] myStack = createStack();

	for (int i = 10; i > 0; i--)
		push(myStack,i);
	System.out.println("You should print [10,9,8,7,6,5,4,3,2,1]");
	System.out.println(prettyPrintStack(myStack));
	System.out.println("This should print 1\n2\n3\n4\n5\n6\n7\n8\n9\n10");

	for (int i = 10; i > 0; i--)
		System.out.println(pop(myStack));

		System.out.println("If you add too many elements into the stack, you should print out an error.");
		
	for (int i = 0; i < 110; i++)
        push(myStack, i);

    task2();
    

	// Task 3 Test Code
	int[] sharesStack = createStack();
	int[] priceStack = createStack();
	push(sharesStack, 100);
	push(priceStack, 20000);
	push(sharesStack, 50);
	push(priceStack, 21000);
	System.out.println("This should print: \nShares\tPrice\n100\t\t$200.00\n50\t\t$210.00");
	printReportFILO(sharesStack, priceStack);
	buyFILO(sharesStack, priceStack, 20, 30050);
	System.out.println("This should print -61000.");
	System.out.println(sellFILO(sharesStack, priceStack, 30, 25000));
	System.out.println("This should print: \nShares\tPrice\n100\t\t$200.00\n40\t\t$210.00");
	System.out.println(runReportFILO(sharesStack, priceStack));
	push(sharesStack, 10);
	push(priceStack, 19999);
	System.out.println("This should print 20267.");
	System.out.println(averageFILO(sharesStack, priceStack));

	// // Task 4 Test Code
	int[] myQueue = createQueue();
    for(int i = 10; i > 0; i--)
        enqueue(myQueue, i);
	System.out.println("You should print [10,9,8,7,6,5,4,3,2,1]");
	System.out.println(prettyPrintQueue(myQueue));
	System.out.println("This should print \n10\n9\n8\n7\n6\n5\n4\n3\n2\n1");
    for(int i = 10; i > 0; i--)
        System.out.println(dequeue(myQueue));
	System.out.println("If you add too many elements into the queue, you should print out an error.");
    for(int i = 0; i < 110; i++)
        enqueue(myQueue, i);
    task5();

	// Task 6 Test Code
	int[] a = createQueue();
	int[] b = createQueue();
	for(int i = 1; i <= 5; i += 2)
	    enqueue(a, i);
	for(int i = 2; i <= 6; i += 2)
	    enqueue(b, i);
	enqueue(a, 40000);
	enqueue(a, 45000);
	enqueue(b, 30000);
	System.out.println("You should print [1,2,3,4,5,6,30000,40000,45000]");
	System.out.println(prettyPrintQueue(merge(a, b)));

	}

	public static int[] createStack() {
        int[] stack = new int[101];
        return stack;
	}

	public static void push(int[] stack, int data) {
        stack[0] += 1;

        if (stack[0] <= 100)
            stack[stack[0]] = data;

        else
            System.out.println("Cannot hold more than 100 items in this stack.");
	}

	public static int pop(int[] stack) {
        int element = stack[stack[0]];
        stack[0]--;
        return element;
	}

	public static String prettyPrintStack(int[] stack) {
        String returnValue = "[";
        for (int i = 1; i <= stack[0]; i++) {
            if (i != stack[0])
                returnValue += stack[i] + ",";
            else
                returnValue += stack[i];
	}

        returnValue += "]";
        return returnValue;
	}

	public static String dumpStack(int[] stack) {
        String returnValue = "{";

        for (int i = 0; i < stack.length; i++) {
            if (i != stack.length - 1)
                returnValue += stack[i] + ",";
            else
                returnValue += stack[i];
        }

        returnValue += "}";
        return returnValue;
	}

	public static void task2() {
        int[] stack = createStack();
        // pushing values from 9 → 3
        for (int i = 9; i > 2; i--)
            push(stack, i);
        
        System.out.println(prettyPrintStack(stack));
        
        // popping values 3 times
        for (int i = 0; i < 3; i++)
            System.out.println("Element popped = " + pop(stack));
        
        // pushing values 1 → 4
        for (int i = 1; i <= 4; i++)
            push(stack, i);
        
        // popping values 5 times
        for (int i = 0; i < 5; i++)
            System.out.println("Element popped = " + pop(stack));
        
        System.out.println(prettyPrintStack(stack));

	}

	public static void printReportFILO(int[] shares, int[] price) {
        System.out.println("Shares \tPrice");
        
        for (int i = 1; i <= shares[0]; i++) {
            System.out.print(shares[i] + "\t$" + price[i] / 100 + ".");
            
            // checking if values are a whole dollar or not
            if (price[i] % 100 > 0)
                System.out.println(price[i] % 100);
            
            else
                System.out.println(price[i] % 100 + "0");
        }
	}

	public static String runReportFILO(int[] shares, int[] price) {
        String returnValue = "Shares \tPrice \n";
        
        for (int i = 1; i <= shares[0]; i++) {
            returnValue += shares[i] + "\t$" + price[i] / 100 + ".";
            
            // checking if values are a whole dollar or not
            if (price[i] % 100 > 0)
                returnValue += price[i] % 100 + "\n";
            
            else
                returnValue += price[i] % 100 + "0 \n";
        }
        
        return returnValue;
	}

	public static void buyFILO(int[] shares, int[] price, int numShares, int pricePerShare) {
        push(shares, numShares);
        push(price, pricePerShare);
	}

	public static int sellFILO(int[] shares, int[] price, int numShares, int pricePerShare) {
        int returnValue = 0;
        int value = 0;
        int sellShares = numShares;

        // loop for calculate the final sell and buy price
        
        for (int i = shares[0]; sellShares > 0; i--) {
            // checks if the selling shares are more than the last buying shares
            if (sellShares >= shares[i]) {
                // calculates the share price
                // changes the last buying shares value to 0
                // changes the second last buying shares value to subtract from the selling shares
                value += shares[i] * price[i];
                sellShares -= shares[i]; 
                shares[i] = 0;
                price[i] = 0;
                shares[0] = shares[0] - 1;
                price[0] = price [0] - 1;
            }

            else {
                // executes when the selling shares are less than the last buying shares
                // calculates the share price
                // changes the last share value by reducing the selling shares value from it
                value += sellShares * price[i];
                shares[i] = shares[i] - sellShares;
                sellShares = -1;
            }
        }

        returnValue = (numShares * pricePerShare) - value;
        return returnValue;

	}

    public static int averageFILO(int[] shares, int[] price) {
        int returnValue = 0;
        int value = 0;
        int numShares = 0;

        // takes the total of all the shares with their respective costs
        // takes the number of shares
        // average cost would be total cost  divided by number of shares

        for (int i = 1; i <= shares[0]; i++) {
            value = value + shares[i] * price[i];
            numShares += shares[i]; 
        }

        returnValue = value / numShares; 
        return returnValue;
    }

    public static int[] createQueue(){
        int[] returnValue = new int[101];
        // sets it to 0 assigned elements
        returnValue[0] = 0;
        return returnValue;
    }
    
    public static void enqueue(int[] queue, int data){
        // adds value to the queue and marks the initial value as increased by one
        queue[0] += 1;
        
        if (queue[0] > 100)
            System.out.println("Cannot hold more than 100 items in this queue.");
        
        else
            queue[queue[0]] = data;
    }
    
    public static int dequeue(int[] queue) {
        // subtracts values from queue[0] and assigns the next value to the descending place
        int returnValue = queue[1];
        
        for (int i = 1; i < queue[0]; i++)
            queue[i] = queue[i+1];
        
        queue[0] -= 1;
        return returnValue;
    }
    
    public static String prettyPrintQueue(int[] queue){
        String returnValue = "[";
        
        for (int i = 1; i < queue[0]; i++) {
            returnValue += queue[i] + ",";
        }

        // avoids the comma
        returnValue += queue[queue[0]] + "]";
        return returnValue;
    }
    
    public static String dumpQueue(int[] queue){
        String returnValue = "{";
        
        for(int i = 0; i < queue.length - 1; i++) {
            returnValue += queue[i] + ",";
        }
        
        // avoids the comma
        returnValue += queue[queue[0]] + "}";
        return returnValue;
    }

    public static void task5(){
        int[] queue = createQueue();
        
        // enqueueing values 9 → 3
        for (int i = 9; i > 2; i--){
            enqueue(queue, i);
        }
        
        // dequeueing values 3 times
        for (int i = 0; i < 2; i++){
            dequeue(queue);
        }
        
        System.out.println(dequeue(queue)); // To print the 3rd dequeue
        
        // enqueueing values 1 → 4
        for (int i = 1; i < 5; i++){
            enqueue(queue, i);
        }
        
        // dequeueing values 5 times
        for (int i = 0; i < 4; i++){
            dequeue(queue);
        }
        
        System.out.println(dequeue(queue));
        System.out.println(prettyPrintQueue(queue));
    }

    public static int[] merge(int[] a, int[] b){
        // checking for any nulls, assuming they are queues instead of arrays
        if (a == null || b == null){
            if (a == null){
                return b;
            }
            else {
                return a;
            }
        }

        // declaring and assigning the queues with createQueue() function
        int[] queueA = createQueue();
        int[] queueB = createQueue();

        // declaring and assigning the queues to their size (first value)
        int queueASize = a[0];
        int queueBSize = b[0];
        // calculate the size of the merged or total queue
        int queueSize = queueASize + queueBSize;

        // assign the values of the queue using the arguments a & b with a loop
        for(int i = 1; i <= queueASize; i++){
            enqueue(queueA, a[i]);
        }
        
        for(int i = 1; i <= queueBSize; i++){
            enqueue(queueB, b[i]);
        }
        
        // create a merged queue as a return value
        int[] returnValue = createQueue();

        // declaring and assigning the position values
        // assigned as 1 since we don't want 0, which is the number of elements
        int queueAPosition = 1;
        int queueBPosition = 1;
        // assign the values in the merged queue with values from queue A and queue B
        
        for(int i = 1; i <= queueSize; i++) {
            // copies queue B if queue A is empty
            if (queueAPosition > queueASize) {
                enqueue(returnValue, queueB[queueBPosition]);
                queueBPosition++;
            }
            
            // copies queue A if queue B is empty
            else if (queueBPosition > queueBSize) {
                enqueue(returnValue, queueA[queueAPosition]);
                queueAPosition++;
            }
            
            else {
                // copies the descending value and increases the positions by 1
                if (queueA[queueAPosition] < queueB[queueBPosition]) {
                    enqueue(returnValue, queueA[queueAPosition]);
                    queueAPosition++;
                } 
                
                else {
                    enqueue(returnValue, queueB[queueBPosition]);
                    queueBPosition++;
                }
            }
        }
        
        return returnValue;
    }

}
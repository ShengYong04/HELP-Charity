package assignment.adt;

import assignment.entity.*;
import java.io.Serializable;
import java.util.Comparator;

public class LinkedList<T> implements LinkedListInterface<T>, Serializable{

    private int numberOfEntries;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    @Override
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public void add(T data) {
        Node<T> node = new Node(data);
        if (numberOfEntries == 0) {
            head = node;
            tail = head;
            tail.setNextNode(head);
            head.setPrevNode(tail);
        } else {
            tail.setNextNode(node);
            node.setNextNode(head);
            node.setPrevNode(tail);
            tail = node;
            head.setPrevNode(tail);
        }
        numberOfEntries++;
    }

    @Override
    public void add(int indexNumber, T data) {
        Node<T> node = new Node(data);
        Node<T> selectedPrevNode = tail;
        Node<T> selectedNode = head;

        if (indexNumber == 1) {
            selectedNode.setPrevNode(node);
            selectedPrevNode.setNextNode(node);
            node.setNextNode(selectedNode);
            node.setPrevNode(selectedPrevNode);
            head = node;
            numberOfEntries++;
        } else if (indexNumber < numberOfEntries) {
            for (int x = 1; x < indexNumber; x++) {
                selectedNode = selectedNode.getNextNode();
            }
            selectedPrevNode = selectedNode.getPrevNode();
            selectedPrevNode.setNextNode(node);
            selectedNode.setPrevNode(node);
            node.setPrevNode(selectedPrevNode);
            node.setNextNode(selectedNode);
            numberOfEntries++;
        } else if (indexNumber == numberOfEntries) {
            tail.getPrevNode().setNextNode(node);
            node.setPrevNode(tail.getPrevNode());
            node.setNextNode(tail);
            tail.setPrevNode(node);
        } else {
            throw new IllegalArgumentException("Parameter must be in the range of 1 to " + numberOfEntries);
        }
    }

    @Override
    public void delete(int indexNumber) {
        Node<T> selectedNode = head;

        if (indexNumber == 1) {
            head = selectedNode.getNextNode();
            tail.setNextNode(head);
            head.setPrevNode(tail);
            numberOfEntries--;
        } else if (indexNumber < numberOfEntries && indexNumber > 1) {
            for (int x = 1; x < indexNumber; x++) {
                selectedNode = selectedNode.getNextNode();
            }
            selectedNode.getNextNode().setPrevNode(selectedNode.getPrevNode());
            selectedNode.getPrevNode().setNextNode(selectedNode.getNextNode());
            numberOfEntries--;
        } else if (indexNumber == numberOfEntries) {
            tail.getNextNode().setPrevNode(tail.getPrevNode());
            tail.getPrevNode().setNextNode(tail.getNextNode());
            tail = tail.getPrevNode();
            numberOfEntries--;
        } else {
            throw new IllegalArgumentException("Parameter must be in the range of 1 to " + numberOfEntries);
        }
    }

    @Override
    public void replace(int indexNumber, T data) {
        Node<T> selectedNode = head;
        if (indexNumber == 1) {
            head.setData(data);
        } else if (indexNumber < numberOfEntries && indexNumber > 1) {
            for (int x = 1; x < indexNumber; x++) {
                selectedNode = selectedNode.getNextNode();
            }

            selectedNode.setData(data);
        } else if (indexNumber == numberOfEntries) {
            tail.setData(data);
        }
    }

    @Override
    public boolean contains(T data) {
        Node<T> currentNode = head;
        
        for(int x = 1; x <= numberOfEntries; x++){
            if(data.equals(currentNode.getData())){
                return true;
            }else{
                currentNode = currentNode.getNextNode();
            }
        }
        return false;
    }

    @Override
    public T readForward(int indexNumber) {
        if (indexNumber == 1) {
            return head.getData();
        } else if (indexNumber < numberOfEntries && indexNumber > 1) {
            Node<T> selectedNode = head;
            for (int x = 1; x < indexNumber; x++) {
                selectedNode = selectedNode.getNextNode();
            }
            return selectedNode.getData();
        } else if (indexNumber == numberOfEntries) {
            return tail.getData();
        } else {
            throw new IllegalArgumentException("Parameter must be in the range of 1 to " + numberOfEntries);
        }
    }

    @Override
    public T readBackwards(int indexNumber) {
        if (indexNumber == 1) {
            return tail.getData();
        } else if (indexNumber < numberOfEntries && indexNumber > 1) {
            Node<T> selectedNode = tail;
            for (int x = 1; x < indexNumber; x++) {
                selectedNode = selectedNode.getPrevNode();
            }
            return selectedNode.getData();
        } else if (indexNumber == numberOfEntries) {
            return head.getData();
        } else {
            throw new IllegalArgumentException("Parameter must be in the range of 1 to " + numberOfEntries);
        }
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    @Override
    public void sort(Comparator<T> comparator){
        head = (mergeSort(head, comparator)); 

        Node currentNode = head;
        
        for (int i = 1; i < numberOfEntries; i++){
            currentNode = currentNode.getNextNode();
        }
        tail = currentNode;
        tail.setNextNode(head);
        head.setPrevNode(tail);
    }
 
    public Node mergeSort(Node<T> head, Comparator<T> comparator) {
        if (head == null || head.getNextNode() == null) {
            return head;
        }
        
        tail.setNextNode(null);
        Node<T> middle = findMiddle(head);
        Node<T> nextOfMiddle = middle.getNextNode();
        middle.setNextNode(null);

        Node<T> left = mergeSort(head, comparator);
        Node<T> right = mergeSort(nextOfMiddle, comparator);

        return merge(left, right, comparator);
    }

    private Node findMiddle(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }
        return slow;
    }

    private Node merge(Node<T> left, Node<T> right, Comparator<T> comparator) {
        Node<T> dummy = new Node(0);
        Node<T> listtail = dummy;
        boolean first = true;

        while (left != null && right != null) {
            if (comparator.compare(left.getData(), right.getData()) < 0) {
                listtail.setNextNode(left);
                left = left.getNextNode();
            } else {
                listtail.setNextNode(right);
                right = right.getNextNode();
            }

            if (first) {
                listtail.getNextNode().setPrevNode(null);
            } else {
                listtail.getNextNode().setPrevNode(listtail);
            }

            listtail = listtail.getNextNode();

            first = false;
        }

        if (left != null) {
            listtail.setNextNode(left);
        } else {
            listtail.setNextNode(right);
        }

        listtail.getNextNode().setPrevNode(listtail);

        return dummy.getNextNode();
    }
    
    @Override
    public void clear(){
        head = null;
        tail = null;
        numberOfEntries = 0;
    }
}



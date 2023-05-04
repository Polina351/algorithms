package lection_4_tree;

import java.awt.*;

public class RedBlackTree {
    private class Node {
        private int value;
        private boolean color; //red -> true
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
            color = true;
        }
    }

    Node rotateLeft(Node node) {
        Node child = node.rightChild;
        Node childLeft = child.leftChild;

        child.leftChild = node;
        node.rightChild = childLeft;

        return child;
    }

    Node rotateRight(Node node) {
       Node child = node.leftChild;
       Node childRight = child.rightChild;

       child.rightChild = node;
       node.leftChild = childRight;

       return child;
    }

    boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return (node.color == true);
    }

    void swapColor(Node node1, Node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            return node;
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild)) {
            node = rotateLeft(node);
            swapColor(node, node.leftChild);
        }

        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)) {
            node = rotateRight(node);
            swapColor(node, node.rightChild);
        }

        if (isRed(node.leftChild) && isRed(node.rightChild)) {
            node.color = !node.color;

            node.leftChild.color = false;
            node.rightChild.color = false;
        }
        return node;
    }
}

# Java_Hash_Maps
This project implements two data structures that follow the Map Abstract Data Type (ADT):

- Binary Search Tree Map (BSTMap): A Map implementation using a Binary Search Tree (BST) for key-value storage.

- Hash Map (HashMap): A separate chaining hash table that resolves collisions using linked lists.

## Features 🚀

- Implemented a BST-based Map structure supporting insertion, search, and deletion.

- Developed a hash map utilizing separate chaining to manage collisions.

- Compared performance metrics for different map implementations.

- Measured operation efficiency based on loop counts in put and get methods.

## Implementation Details

# BSTMap

- Uses a self-balancing Binary Search Tree to store key-value pairs.

- Supports basic operations: put(K key, V value), get(K key), and containsKey(K key).

- Performs insertions and lookups in O(log n) time complexity in balanced cases.

# HashMap

- Uses Java's List (ArrayList) as the underlying storage structure.

- Implements separate chaining using List<Entry<K, V>> for collision resolution.

- Supports operations: put(K key, V value), get(K key), containsKey(K key), and entryList().

- Achieves expected O(1) time complexity for put and get operations.

I completed this assignment as a final for my CSC 115 class, I was able to use my knowledge gained on Java language throughout the course and bring it all together. 

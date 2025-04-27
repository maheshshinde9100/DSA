
# Java Collections, Stream API, and Lambda Expressions

A quick and clean summary of the most important concepts you must know for Java Collections, Stream API, and Lambda expressions.

---

## 📚 Java Collections

The **Collections Framework** provides classes and interfaces to store and manipulate groups of data.

### 1. Collection Hierarchy
- **Interface**: Collection
  - List (ordered, allows duplicates)
  - Set (unordered, no duplicates)
  - Queue (FIFO structure)
- Map (Key-Value pairs) *(Not a part of Collection interface directly)*

### 2. Important Classes
| Interface | Implementations |
|-----------|-----------------|
| List      | ArrayList, LinkedList, Vector, Stack |
| Set       | HashSet, LinkedHashSet, TreeSet |
| Queue     | PriorityQueue, ArrayDeque |
| Map       | HashMap, LinkedHashMap, TreeMap, Hashtable |

### 3. List
Ordered collection. Allows duplicate elements.
```java
List<String> list = new ArrayList<>();
```

### 4. Set
No duplicate elements.
```java
Set<Integer> set = new HashSet<>();
```

### 5. Queue
Elements are processed in FIFO order.
```java
Queue<String> queue = new LinkedList<>();
```

### 6. Map
Key-Value pairs, where keys are unique.
```java
Map<Integer, String> map = new HashMap<>();
```

### 7. Utility Classes
- Collections — static methods for sorting, reversing, etc.
- Arrays — static methods for arrays.

### 8. Major Concepts
- Iterator and ListIterator for traversing collections.
- **Comparable** vs **Comparator**:
  - Comparable — natural ordering.
  - Comparator — custom ordering.

---

## 🚀 Java Stream API

### 1. What is a Stream?
A sequence of elements supporting aggregate operations (map, filter, reduce, etc.). It does not store data itself.

### 2. Creating Streams
From Collections:
```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```
From Arrays:
```java
Stream<int[]> stream = Stream.of(new int[]{1, 2, 3});
```

### 3. Important Stream Operations
- **Intermediate Operations** (return a Stream, lazy):
  - .filter()
  - .map()
  - .sorted()
  - .distinct()
  - .limit()
  - .skip()
- **Terminal Operations** (end stream, produce a result):
  - .forEach()
  - .collect()
  - .reduce()
  - .count()
  - .anyMatch(), .allMatch(), .noneMatch()

### 4. Example
```java
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.stream()
     .filter(name -> name.startsWith("J"))
     .forEach(System.out::println);
```

### 5. Collectors Class
- Collectors.toList()
- Collectors.toSet()
- Collectors.joining()
- Collectors.groupingBy()
- Collectors.partitioningBy()

---

## ⚡ Java Lambda Expressions

### 1. Basic Syntax
```java
(parameters) -> { body }
```
Example:
```java
(a, b) -> a + b
```

### 2. Functional Interfaces
Interface with only **one abstract method**.
Examples:
- Runnable
- Callable
- Comparator
- Custom interfaces annotated with @FunctionalInterface

### 3. Usage Example
Without Lambda:
```java
new Thread(new Runnable() {
    public void run() {
        System.out.println("Running...");
    }
}).start();
```
With Lambda:
```java
new Thread(() -> System.out.println("Running...")).start();
```

### 4. Common Functional Interfaces
| Interface | Description | Example |
|-----------|-------------|---------|
| Predicate<T> | boolean test(T t) | x -> x > 10 |
| Function<T,R> | R apply(T t) | x -> x + 5 |
| Consumer<T> | void accept(T t) | x -> System.out.println(x) |
| Supplier<T> | T get() | () -> "Hello" |

---

# ✨ Summary
- **Collections**: Data structures like List, Set, Map, Queue.
- **Stream API**: Functional operations on collections using streams.
- **Lambda Expressions**: Anonymous functions for cleaner, shorter code.

---

# 📖 Happy Learning!

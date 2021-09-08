package vadim_nedrega.HW5Collections.LinkList;


import java.util.*;

public class MyLinkList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyLinkList.Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null && currentNode.next != null;
            }

            @Override
            public E next() {
                E result = null;
                try {
                    result = currentNode.element;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                currentNode = currentNode.next;
                return result;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkList.Node<E> node = first; node != null; node = node.next)
            result[i++] = node.element;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size); // подсмотрел реализацию, но до сих пор не понял это выражение
        int i = 0;
        Object[] result = a;
        for (MyLinkList.Node<E> x = first; x != null; x = x.next)
            result[i++] = x.element;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> currentNode;
        currentNode = first;
        int i = 0;
        while (currentNode != null) {
            if (i == indexOf(o)) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }
            currentNode = currentNode.next;
            i++;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return c.stream().allMatch(this::contains); //не до конца разобрался со стримом
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E data : c) {
            add(data);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        get(index);
        for (E data : c) {
            add(index, data);
        }


        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object item : c) {
            if (result) {
                remove(item);
            } else {
                result = remove(item);
            }
        }
        return false;

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Iterator<E> iterator = iterator();

        boolean found = false;
        while (iterator.hasNext()) {
            if (!c.contains(iterator.next())) {
                iterator.remove();
                found = true;
            }
        }

        return found;

    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        E element = null;
        Node<E> currentNode;
        currentNode = first;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                return currentNode.element;
            }
            currentNode = currentNode.next;
            i++;
        }
        return element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> currentNode;
        currentNode = first;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                return currentNode.element;
            }
            currentNode = currentNode.next;
            i++;
        }
        currentNode.element = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node<>();
        newNode.element = element;

        Node<E> currentNode = first.prev;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                currentNode.prev.next = newNode;
                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                currentNode.prev = newNode;
                break;
            }
            currentNode = currentNode.next;
            i++;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> target = null;
        try {
            target.element = get(index);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        E result = target.element;

        target.prev.next = target.next;
        target.next.prev = target.prev;

        size--;


        return result;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (MyLinkList.Node<E> node = first; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (MyLinkList.Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (MyLinkList.Node<E> node = last; node != null; node = node.prev) {
                index--;
                if (node.element == null)
                    return index;
            }
        } else {
            for (MyLinkList.Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.element))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<E> subList = new LinkedList<>();
        int index = fromIndex;
        Node<E> target = null;
        Node<E> currentNode;
        currentNode = first;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                target = currentNode;
                break;
            }
            currentNode = currentNode.next;
            i++;
        }
        while (currentNode != null && index <= toIndex) {
            subList.add(currentNode.element);
            currentNode = currentNode.next;
            index++;
        }
        return subList;
    }

    public void addFirst(Object e) {
        Node<E> temp = first;
        Node<E> newNode = new Node<>((E) e);
        newNode.next = first;
        first = newNode;
        if (temp == null) {
            last = newNode;
        } else {
            temp.prev = newNode;
        }
        size++;
    }

    public void addLast(Object e) {
        Node<E> temp = last;
        Node<E> newNode = new Node<>((E) e);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element) {
            this.element = element;
        }

        public Node() {

        }

    }

    private class MyListIterator implements ListIterator<E> {
        private Node<E> currentNode = first;
        private int index;

        public MyListIterator() {
            this(0);
        }

        public MyListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return MyLinkList.this.get(index + 1) != null;
        }

        @Override
        public E next() {
            E result = currentNode.element;
            try {
                currentNode = currentNode.next;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            index++;
            return result;
        }

        @Override
        public boolean hasPrevious() {
            return MyLinkList.this.get(index - 1) != null;
        }

        @Override
        public E previous() {
            E result = currentNode.element;
            try {
                currentNode = currentNode.prev;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            index--;
            return result;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            MyLinkList.this.remove(index);
        }

        @Override
        public void set(E e) {
            Node<E> currentNode;
            Node<E> target = null;
            currentNode = first;
            int i = 0;
            while (currentNode != null) {
                if (i == index) {
                    target = currentNode;
                    currentNode.element = e;
                    break;
                }
                currentNode = currentNode.next;
                i++;
            }
        }

        @Override
        public void add(E e) {
            MyLinkList.this.add(e);
        }

    }

}

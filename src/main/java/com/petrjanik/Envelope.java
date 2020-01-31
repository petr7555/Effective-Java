package com.petrjanik;

class Envelope {
    public Enclosure enclosure = new Envelope.Enclosure();

    void x(String param) {
        System.out.println("Hello from " + param);
    }

    class Enclosure {
        void x(String param) {
            Envelope.this.x(param); /* Qualified*/
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Envelope envelope = new Envelope();
        envelope.enclosure.x("one");
        Envelope.Enclosure enclosure = envelope.new Enclosure();
        enclosure.x("two");
    }
}
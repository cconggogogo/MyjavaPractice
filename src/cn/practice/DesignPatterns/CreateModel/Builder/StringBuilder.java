package cn.practice.DesignPatterns.CreateModel.Builder;

public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        // Create a copy, don't share the _03_array
        return new String(value, 0, count);
    }
}


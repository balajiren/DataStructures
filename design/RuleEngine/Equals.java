package RuleEngine;

import java.util.Map;
import java.util.Stack;

public class Equals extends Operation
{      
    public Equals()
    {
        super("=");
    }

    @Override
    public Equals copy()
    {
        return new Equals();
    }

    @Override
    public int parse(final String[] tokens, int pos, Stack<Expression> stack)
    {
        if (pos-1 >= 0 && tokens.length >= pos+1)
        {
            String var = tokens[pos-1];

            this.leftOperand = new Variable(var);
            this.rightOperand = BaseType.getBaseType(tokens[pos+1]);
            stack.push(this);

            return pos+1;
        }
        throw new IllegalArgumentException("Cannot assign value to variable");
    }

    @Override
    public boolean interpret(Map<String, ?> bindings)
    {
        Variable v = (Variable)this.leftOperand;
        Object obj = bindings.get(v.getName());
        if (obj == null)
            return false;

        BaseType<?> type = (BaseType<?>)this.rightOperand;
        if (type.getType().equals(obj.getClass()))
        {
            if (type.getValue().equals(obj))
                return true;
        }
        return false;
    }

}
package RuleEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rule
{
    private List<Expression> expressions;
    private static ActionDispatcher dispatcher;

    public static class Builder
    {
        private List<Expression> expressions = new ArrayList<>();
        //private ActionDispatcher dispatcher = new NullActionDispatcher();
		private ActionDispatcher dispatcher;

        public Builder withExpression(Expression expr)
        {
            expressions.add(expr);
            return this;
        }

        public Builder withDispatcher(ActionDispatcher dispatcher)
        {
            this.dispatcher = dispatcher;
            return this;
        }

        public Rule build()
        {
            return new Rule(expressions, dispatcher);
        }
    }

    private Rule(List<Expression> expressions, ActionDispatcher dispatcher)
    {
        this.expressions = expressions;
        this.dispatcher = dispatcher;
    }

    public boolean eval(Map<String, ?> bindings)
    {
        boolean eval = false;
        for (Expression expression : expressions)
        {
            eval = expression.interpret(bindings);
            if (eval)
                dispatcher.fire();
        }
        return eval;
    }
}
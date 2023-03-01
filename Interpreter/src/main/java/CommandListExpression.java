import java.util.ArrayList;

public class CommandListExpression implements Expression {

    private final ArrayList<CommandExpression> commands = new ArrayList<>();

    @Override
    public boolean parse(Context context) {
        while (true) {
            String currentKeyword = context.getCurrentKeyword();

            if(currentKeyword == null) {
                return false;
            } else if (currentKeyword.equals("END")) {
                context.readNextKeyword();
                break;
            } else {
                CommandExpression command = null;

                if(LoopCommandExpression.checkValidKeyword(currentKeyword)) {
                    command = new LoopCommandExpression(currentKeyword);
                } else if(ActionCommandExpression.checkValidKeyword(currentKeyword)) {
                    command = new ActionCommandExpression(currentKeyword);
                }

                if(command != null) {
                    if(command.parse(context)) {
                        commands.add(command);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean run() {

        for (CommandExpression command : commands) {
            boolean bOK = command.run();
            if (!bOK) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return commands.toString();
    }
}

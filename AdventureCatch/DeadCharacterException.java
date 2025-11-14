public class DeadCharacterException extends Exception{
    Character c;
    public DeadCharacterException(Character c){
        this.c = c;
    }

    @Override
    public String getMessage() {
        return String.format("The %s %s is dead.", c.getClass().getSimpleName().toLowerCase(), c.getName());
    }
}
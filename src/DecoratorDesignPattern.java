
// Decorator Design Pattern:
// - It attaches additional responsibilities to an object dynamically

abstract class Character
{
    abstract String getAbilities();
}
class MarioCharacter extends Character
{
    @Override
    public String getAbilities()
    {
        return "Mario\n";
    }
}
abstract class CharacterDecorator extends Character
{
    protected Character character;
    public CharacterDecorator(Character character)
    {
        this.character = character;
    }
}
class HeightUp extends CharacterDecorator
{
    public HeightUp(Character character)
    {
        super(character);
    }
    @Override
    public String getAbilities()
    {
        return character.getAbilities() + " with HeightUp\n";
    }
}
class GunPowerUp extends CharacterDecorator
{
    public GunPowerUp(Character character)
    {
        super(character);
    }
    @Override
    public String getAbilities()
    {
        return character.getAbilities() + " with GunPowerUp\n";
    }
}
class StarPowerUp extends CharacterDecorator
{
    public StarPowerUp(Character character)
    {
        super(character);
    }
    @Override
    public String getAbilities()
    {
        return character.getAbilities() + " with StarPowerUp (Limited Time)\n";
    }
}

public class DecoratorDesignPattern
{
    public static void main(String[] args)
    {
//        Character character = new MarioCharacter();
//        character = new HeightUp(character);
//        System.out.println(character.getAbilities());
//        character = new GunPowerUp(character);
//        System.out.println(character.getAbilities());
//        character = new StarPowerUp(character);
//        System.out.println(character.getAbilities());

        // Alternatives
        Character mario = new HeightUp(new MarioCharacter());
        System.out.println(mario.getAbilities());
        mario = new GunPowerUp(new HeightUp(new MarioCharacter()));
        System.out.println(mario.getAbilities());
        mario = new StarPowerUp(new GunPowerUp(new HeightUp(new MarioCharacter())));
        System.out.println(mario.getAbilities());
        // It will be executed like recursion that adds extra functionalities to an object
    }
}

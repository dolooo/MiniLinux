package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Rm_path extends CommandVariation {
    public Rm_path(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        Composite elementToRemove = new Composite();
        elementToRemove.setName(params);
        try {
            c.removeElement(elementToRemove);
            System.out.println("Usunieto " + params);
        } catch (Exception e) {
            System.out.print("Nie udało się usunąć " + params + " " + e.getMessage());
        }
    }
}
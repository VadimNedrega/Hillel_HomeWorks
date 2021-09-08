package vadim_nedrega.HW11_Decorator;

import vadim_nedrega.HW11_Decorator.Decorators.CellDecorator;
import vadim_nedrega.HW11_Decorator.Decorators.CoordinateDecorator;
import vadim_nedrega.HW11_Decorator.Decorators.FigureDecorator;
import vadim_nedrega.HW11_Decorator.Decorators.WhiskeyBottleDecorator;
import vadim_nedrega.HW11_Decorator.Objects.Board;
import vadim_nedrega.HW11_Decorator.Objects.Component;
import vadim_nedrega.HW11_Decorator.Objects.Player;

public class Program_11_01 {
    public static void main(String[] args) {

        Player player1 = new Player("Михалыч", true);
        Player player2 = new Player("Потапыч", true);

        Component board;
        if (player1.isWantBooze() && player2.isWantBooze()) {
            board = new WhiskeyBottleDecorator(new Board());
        } else if (player1.isWantBooze() || player2.isWantBooze()) {
            board = new WhiskeyBottleDecorator(
                    new FigureDecorator(
                            new CoordinateDecorator(
                                    new CellDecorator(
                                            new Board()))));
        } else {
            board = new FigureDecorator(
                    new CoordinateDecorator(
                            new CellDecorator(
                                    new Board())));
        }
        board.add();

        player1.play(player2);

    }
}

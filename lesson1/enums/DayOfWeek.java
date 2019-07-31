/**
 * Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
 * С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.
 *
 *  Возвращает кол-во оставшихся рабочих часов до конца
 *  недели по заданному текущему дню. Считается, что
 *  текущий день ещё не начался, и рабочие часы за него
 *  должны учитываться.
 *  Если заданный день выходной то вывести "Сегодня выходной"
 */

package enums;

public enum DayOfWeek {
    Monday(1), Tuersday(2), Wednesday(3), Thursday(4), Friday(5), Saterday(6), Sunday(7);

    int num;

    DayOfWeek(int num) {
        this.num = num;
    }

    static public String getWorkingHours(DayOfWeek dof) {
        if(dof.num > 5)
            return "Сегодня выходной";
        else {
            int n = 0;
            for( int i = dof.num; i < Saterday.num; i++)
            {
                n++;
            }
            return "Рабочих часов до конца недели " + n*8;
        }
    }
}

package lipeng.two;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class Cinema {
    // 1号厅票数
    private long ticketCount1;
    // 2号厅票数
    private long ticketCount2;
    private final Object controlCinema1, controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        ticketCount1 = 20;
        ticketCount2 = 20;
    }

    /**
     * 1 号厅售票
     *
     * @param number
     * @return
     */
    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < ticketCount1) {
                ticketCount1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 2 号厅售票
     *
     * @param number
     * @return
     */
    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < ticketCount2) {
                ticketCount2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 1 号厅退票
     *
     * @param number
     * @return
     */
    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < ticketCount1) {
                ticketCount1 += number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 2 号厅退票
     *
     * @param number
     * @return
     */
    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < ticketCount2) {
                ticketCount2 += number;
                return true;
            } else {
                return false;
            }
        }
    }

    public long getTicketCount1() {
        return ticketCount1;
    }


    public long getTicketCount2() {
        return ticketCount2;
    }
}

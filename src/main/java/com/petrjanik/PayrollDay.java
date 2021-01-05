package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 06.02.2020
 */
//public enum PayrollDay {
//    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
//
//    private static final int MINS_PER_SHIFT = 8 * 60;
//
//    int pay(int minutesWorked, int payRate) {
//        int basePay = minutesWorked * payRate;
//
//        int overtimePay;
//        switch (this) {
//            case SATURDAY:
//            case SUNDAY:
//                overtimePay = basePay / 2;
//                break;
//            default:
//                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
//        }
//        return basePay + overtimePay;
//    }
//}

//public enum PayrollDay {
//    MONDAY, TUESDAY,
//    SATURDAY {
//        @Override
//        int overtimePay(int minutesWorked, int payRate) {
//            return weekendOvertimePay(minutesWorked, payRate);
//        }
//    }, SUNDAY {
//        @Override
//        int overtimePay(int minutesWorked, int payRate) {
//            return weekendOvertimePay(minutesWorked, payRate);
//        }
//    };
//
//    private static final int MINS_PER_SHIFT = 8 * 60;
//
//    int workdayOvertimePay(int minutesWorked, int payRate) {
//        return minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
//    }
//
//    int weekendOvertimePay(int minutesWorked, int payRate) {
//        return minutesWorked * payRate / 2;
//    }
//
//    int pay(int minutesWorked, int payRate) {
//        int basePay = minutesWorked * payRate;
//        return basePay + overtimePay(minutesWorked, payRate);
//    }
//
//    int overtimePay(int minutesWorked, int payRate) {
//        return workdayOvertimePay(minutesWorked, payRate);
//    }
//}

public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY); // Default
    }

    private enum PayType {
        WEEKDAY {
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int minutesWorked, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;
            return basePay + overtimePay(minutesWorked, payRate);
        }
    }
}

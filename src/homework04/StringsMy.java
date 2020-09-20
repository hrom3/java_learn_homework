package homework04;

import homework02.CountNumeralsInNumber;

public class StringsMy {

    public String toString(int number) {
        int lengthOfNumber;
        boolean isFirstNUmber = true;
        String sign = "";

        if (number < 0) {
            sign = "Минус ";
            number = -number;
            isFirstNUmber = false;
        }

        lengthOfNumber = CountNumeralsInNumber.lengthOfNumber(number);

        switch (lengthOfNumber) {
            case 1:
            case 2:
            case 3:
                return sign + nullToNineHundredNinetyNine(number,
                        isFemaleGender(lengthOfNumber), isFirstNUmber);
            case 4:
            case 5:
            case 6: {
                return sign + thousandToMillion(number, isFirstNUmber, false);
            }
            case 7:
            case 8:
            case 9: {
                return sign + millionToBillion(number, isFirstNUmber, false);
            }
            default:
                return "it's not work yet";
        }
    }

    public String toString(double number) {
        if (number < -999_999_999.99 || number > 999_999_999.99) {
            return "Bad data";
        }
        int numberInt;
        boolean isFirstNUmber = true;
        String sign = "";
        int lengthOfNumber;
        int fractionalPart;

        if (number < 0) {
            sign = "Минус ";
            number = -number;
            isFirstNUmber = false;
        }

        numberInt = (int) number;
        fractionalPart = (int) ((number - numberInt) * 100);
        lengthOfNumber = CountNumeralsInNumber.lengthOfNumber(numberInt);

        switch (lengthOfNumber) {
            case 1:
            case 2:
            case 3:
                return sign + nullToNineHundredNinetyNine(numberInt,
                        true, isFirstNUmber) + additionalWords(numberInt, -1)
                        + nullToNinetyNine(fractionalPart, true, false)
                        + additionalWords(fractionalPart, -2);
            case 4:
            case 5:
            case 6: {
                return sign + thousandToMillion(numberInt, isFirstNUmber, true)
                        + additionalWords(numberInt, -1)
                        + nullToNinetyNine(fractionalPart, true, false)
                        + additionalWords(fractionalPart, -2);
            }
            case 7:
            case 8:
            case 9: {
                return sign + millionToBillion(numberInt, isFirstNUmber, true)
                        + additionalWords(numberInt, -1)
                        + nullToNinetyNine(fractionalPart, true, false)
                        + additionalWords(fractionalPart, -2);
            }
            default:
                return "it's not work yet";
        }
    }

    public String toWeek(int number) {
        if (number < 0) {
            return "Bad date";
        }
        int weeks = number / 7;

        return weeks + additionalWords(weeks, -3);
    }

    private String nullToNine(int number, boolean isFemaleGender,
                              boolean isFirstNumber) {
        switch (number) {
            case 0: {
                if (!isFirstNumber) {
                    return "ноль ";
                } else {
                    return "Ноль ";
                }
            }
            case 1: {
                if (!isFirstNumber) {
                    if (!isFemaleGender) {
                        return "один ";
                    } else {
                        return "одна ";
                    }
                } else {
                    if (!isFemaleGender) {
                        return "Один ";
                    } else {
                        return "Одна ";
                    }
                }
            }
            case 2: {
                if (!isFirstNumber) {
                    if (!isFemaleGender) {
                        return "два ";
                    } else {
                        return "две ";
                    }
                } else {
                    if (!isFemaleGender) {
                        return "Два ";
                    } else {
                        return "Две ";
                    }
                }
            }
            case 3: {
                if (!isFirstNumber) {
                    return "три ";
                } else {
                    return "Три ";
                }
            }
            case 4: {
                if (!isFirstNumber) {
                    return "четыре ";
                } else {
                    return "Четыре ";
                }
            }
            case 5: {
                if (!isFirstNumber) {
                    return "пять ";
                } else {
                    return "Пять ";
                }
            }
            case 6: {
                if (!isFirstNumber) {
                    return "шесть ";
                } else {
                    return "Шесть ";
                }
            }
            case 7: {
                if (!isFirstNumber) {
                    return "семь ";
                } else {
                    return "Семь ";
                }
            }
            case 8: {
                if (!isFirstNumber) {
                    return "восемь ";
                } else {
                    return "Восемь ";
                }
            }
            case 9: {
                if (!isFirstNumber) {
                    return "девять ";
                } else {
                    return "Девять ";
                }
            }
            default:
                return "bad";
        }
    }

    private String tenToNineteen(int number, boolean isFirstNumber) {
        switch (number) {
            case 10: {
                if (!isFirstNumber) {
                    return "десять ";
                } else {
                    return "Десять ";
                }
            }
            case 11: {
                if (!isFirstNumber) {
                    return "одиннадцать ";
                } else {
                    return "Одиннадцать ";
                }
            }
            case 12: {
                if (!isFirstNumber) {
                    return "двенадцать ";
                } else {
                    return "Ддвенадцать ";
                }
            }
            case 13: {
                if (!isFirstNumber) {
                    return "тринадцать ";
                } else {
                    return "Тринадцать ";
                }
            }
            case 14: {
                if (!isFirstNumber) {
                    return "четырнадцать ";
                } else {
                    return "Четырнадцать ";
                }
            }
            case 15: {
                if (!isFirstNumber) {
                    return "пятнадцать ";
                } else {
                    return "Пятнадцать ";
                }
            }
            case 16: {
                if (!isFirstNumber) {
                    return "шестнадцать ";
                } else {
                    return "Шестнадцать ";
                }
            }
            case 17: {
                if (!isFirstNumber) {
                    return "семнадцать ";
                } else {
                    return "Семнадцать ";
                }
            }
            case 18: {
                if (!isFirstNumber) {
                    return "восемнадцать ";
                } else {
                    return "Восемнадцать ";
                }
            }
            case 19: {
                if (!isFirstNumber) {
                    return "девятнадцать ";
                } else {
                    return "Девятнадцать ";
                }
            }
            default:
                return "bad";
        }
    }

    private String twentyToNinetyNine(int number, boolean isFemaleGender,
                                      boolean isFirstNumber) {
        int number1 = number / 10;
        int number2 = number % 10;

        String nullToNine = number2 != 0 ? nullToNine(number2, isFemaleGender,
                false) : "";

        switch (number1) {
            case 2: {
                if (!isFirstNumber) {
                    return "двадцать " + nullToNine;
                } else {
                    return "Двадцать " + nullToNine;
                }
            }
            case 3: {
                if (!isFirstNumber) {
                    return "тридцать " + nullToNine;
                } else {
                    return "Тридцать " + nullToNine;
                }
            }
            case 4: {
                if (!isFirstNumber) {
                    return "сорок " + nullToNine;
                } else {
                    return "Сорок " + nullToNine;
                }
            }
            case 5: {
                if (!isFirstNumber) {
                    return "пятьдесят " + nullToNine;
                } else {
                    return "Пятьдесят " + nullToNine;
                }
            }
            case 6: {
                if (!isFirstNumber) {
                    return "шестьдесят " + nullToNine;
                } else {
                    return "Шестьдесят " + nullToNine;
                }
            }
            case 7: {
                if (!isFirstNumber) {
                    return "семьдесят " + nullToNine;
                } else {
                    return "Семьдесят " + nullToNine;
                }
            }
            case 8: {
                if (!isFirstNumber) {
                    return "восемьдесят " + nullToNine;
                } else {
                    return "Восемьдесят " + nullToNine;
                }
            }
            case 9: {
                if (!isFirstNumber) {
                    return "девяносто " + nullToNine;
                } else {
                    return "Девяносто " + nullToNine;
                }
            }
            default:
                return "bad";
        }
    }

    private String nullToNinetyNine(int number, boolean isFemaleGender,
                                    boolean isFirstNumber) {
        if (number < 10) {
            return nullToNine(number, isFemaleGender, isFirstNumber);
        } else if (number < 20) {
            return tenToNineteen(number, isFirstNumber);
        } else {
            return twentyToNinetyNine(number, isFemaleGender, isFirstNumber);
        }
    }

    private String nullToNineHundredNinetyNine(int number,
                                               boolean isFemaleGender,
                                               boolean isFirstNumber) {
        int number1 = number / 100;
        int number2 = number % 100;

        String nullToNinetyNine = number2 != 0 ? nullToNinetyNine(number2,
                isFemaleGender, false) : "";

        switch (number1) {
            case 0:
                return nullToNinetyNine(number2, isFemaleGender, isFirstNumber);
            case 1: {
                if (!isFirstNumber) {
                    return "сто " + nullToNinetyNine;
                } else {
                    return "Сто " + nullToNinetyNine;
                }
            }
            case 2: {
                if (!isFirstNumber) {
                    return "двесте " + nullToNinetyNine;
                } else {
                    return "Двесте " + nullToNinetyNine;
                }
            }
            case 3: {
                if (!isFirstNumber) {
                    return "триста " + nullToNinetyNine;
                } else {
                    return "Триста " + nullToNinetyNine;
                }
            }
            case 4: {
                if (!isFirstNumber) {
                    return "четырста " + nullToNinetyNine;
                } else {
                    return "Четырста " + nullToNinetyNine;
                }
            }
            case 5: {
                if (!isFirstNumber) {
                    return "пятьсот " + nullToNinetyNine;
                } else {
                    return "Пятьсот " + nullToNinetyNine;
                }
            }
            case 6: {
                if (!isFirstNumber) {
                    return "шестьсот " + nullToNinetyNine;
                } else {
                    return "Шестьсот " + nullToNinetyNine;
                }
            }
            case 7: {
                if (!isFirstNumber) {
                    return "семьсот " + nullToNinetyNine;
                } else {
                    return "Семьсот " + nullToNinetyNine;
                }
            }
            case 8: {
                if (!isFirstNumber) {
                    return "восемьсот " + nullToNinetyNine;
                } else {
                    return "Восемьсот " + nullToNinetyNine;
                }
            }
            case 9: {
                if (!isFirstNumber) {
                    return "девятьсот " + nullToNinetyNine;
                } else {
                    return "Девятьсот " + nullToNinetyNine;
                }
            }
            default:
                return "bad";
        }
    }

    private String additionalWords(int number, int flag) {
        number = number > 20 ? number % 10 : number;

        switch (number) {
            case 1: {
                if (flag > 3 && flag < 7) {
                    return "тысяча ";
                } else if (flag >= 7) {
                    return "миллион ";
                } else if (flag == -1) {
                    return "целая ";
                } else if (flag == -2) {
                    return "десятая ";
                } else if (flag == -3) {
                    return " неделя";
                }
            }
            case 2:
            case 3:
            case 4: {
                if (flag > 3 && flag < 7) {
                    return "тысячи ";
                } else if (flag >= 7) {
                    return "миллиона ";
                } else if (flag == -3) {
                    return " недели";
                }
            }
            default: {
                if (flag > 3 && flag < 7) {
                    return "тысяч ";
                } else if (flag >= 7) {
                    return "миллионов ";
                } else if (flag == -1) {
                    return "целых ";
                } else if (flag == -2) {
                    return "десятых ";
                } else if (flag == -3) {
                    return " недель";
                }
            }
        }
        return "";
    }

    private boolean isFemaleGender(int number) {
        int lengthOfNumber = CountNumeralsInNumber.lengthOfNumber(number);
        return lengthOfNumber > 3 && lengthOfNumber < 7;
    }

    private String thousandToMillion(int number, boolean isFirstNumber,
                                     boolean isFemale) {
        int lengthOfNumber = CountNumeralsInNumber.lengthOfNumber(number);
        int number1 = number / 1_000;
        int number2 = number % 1_000;
        String nullToNinetyNine;
        if (number2 == 0) {
            nullToNinetyNine = "";
        } else if (isFemale) {
            nullToNinetyNine = nullToNineHundredNinetyNine(number2,
                    isFemale, false);
        } else nullToNinetyNine = nullToNineHundredNinetyNine(number2,
                isFemaleGender(number2),false);

        return nullToNineHundredNinetyNine(number1, isFemaleGender(number),
                isFirstNumber) + additionalWords(number1, lengthOfNumber)
                + nullToNinetyNine;
    }

    private String millionToBillion(int number, boolean isFirstNumber,
                                    boolean isFemale) {
        int lengthOfNumber = CountNumeralsInNumber.lengthOfNumber(number);
        int number1 = number / 1_000_000;
        int number2 = number % 1_000_000;

        String nullToMillion = number2 != 0 ? thousandToMillion(number2,
                false, isFemale) : "";

        return nullToNineHundredNinetyNine(number1, isFemaleGender(number),
                isFirstNumber) + additionalWords(number1, lengthOfNumber)
                + nullToMillion;
    }
}


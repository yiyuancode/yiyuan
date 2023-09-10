package net.yiyuan.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {
    private static final Logger logger = LoggerFactory.getLogger(CheckUtil.class);

    public CheckUtil() {
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        } else if (phoneNumber.length() != 11) {
            return false;
        } else {
            String regex = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }
    }

    public static boolean checkLandline(String phoneNumber) {
        Matcher m = null;
        boolean isPhone = false;
        Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");
        Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");
        if (phoneNumber.length() > 9) {
            isPhone = p1.matcher(phoneNumber).matches();
        } else {
            isPhone = p2.matcher(phoneNumber).matches();
        }

        return isPhone;
    }

    public static boolean checkTWPassCard(String card) {
        String reg = "^\\d{8}|^[a-zA-Z0-9]{10}|^[a-zA-Z0-9]{9}|^\\d{18}$";
        return card.matches(reg);
    }

    public static boolean checkGAPassCard(String card) {
        String reg = "^([A-Z]\\d{6,10}(\\(\\w{1}\\))?)$";
        return card.matches(reg);
    }

    public static boolean checkGATLiveCard(String card) {
        String reg = "^8[123]0000(?:19|20)\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])\\d{3}[\\dX]$";
        return card.matches(reg);
    }

    public static boolean checkIDCard(String card) {
        if (card != null && !"".equals(card)) {
            String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
            boolean matches = card.matches(regularExpression);
            if (matches && card.length() == 18) {
                try {
                    char[] charArray = card.toCharArray();
                    int[] idCardWi = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    String[] idCardY = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;

                    int idCardMod;
                    for(int i = 0; i < idCardWi.length; ++i) {
                        idCardMod = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = idCardMod * idCardWi[i];
                        sum += count;
                    }

                    char idCardLast = charArray[17];
                    idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() + "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }
                } catch (Exception var10) {
                    logger.error("身份证检验异常", var10);
                    return false;
                }
            } else {
                return matches;
            }
        } else {
            return false;
        }
    }

    public static boolean isLicense18(String license) {
        if (StringUtils.isEmpty(license)) {
            return false;
        } else if (license.length() != 18) {
            return false;
        } else {
            String regex = "^([1-9ANY]{1})([123459]{1})([0-9ABCDEFGHJKLMNPQRTUWXY]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-90-9ABCDEFGHJKLMNPQRTUWXY])$";
            if (!license.matches(regex)) {
                return false;
            } else {
                String str = "0123456789ABCDEFGHJKLMNPQRTUWXY";
                int[] ws = new int[]{1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
                String[] codes = new String[]{license.substring(0, license.length() - 1), license.substring(license.length() - 1, license.length())};
                int sum = 0;

                int c18;
                for(c18 = 0; c18 < 17; ++c18) {
                    sum += str.indexOf(codes[0].charAt(c18)) * ws[c18];
                }

                c18 = 31 - sum % 31;
                if (c18 == 31) {
                    c18 = 0;
                }

                return str.charAt(c18) == codes[1].charAt(0);
            }
        }
    }
}

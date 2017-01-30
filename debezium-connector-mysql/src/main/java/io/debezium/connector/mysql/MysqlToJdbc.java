/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.mysql;

import java.sql.Types;

public class MysqlToJdbc {

    public static int mysqlToJdbcType(int mysqlType) {
        // See https://github.com/percona/percona-server/blob/1e2f003a5bd48763c27e37542d97cd8f59d98eaa/libbinlogevents/export/binary_log_types.h#L38
        // See https://github.com/debezium/debezium/blob/v0.3.6/debezium-connector-mysql/src/main/java/io/debezium/connector/mysql/MySqlDdlParser.java#L75
        /*
        MYSQL_TYPE_DECIMAL, // 0
        MYSQL_TYPE_TINY, // 1
        MYSQL_TYPE_SHORT, // 2
        MYSQL_TYPE_LONG, // 3
        MYSQL_TYPE_FLOAT, // 4
        MYSQL_TYPE_DOUBLE, // 5
        MYSQL_TYPE_NULL, // 6
        MYSQL_TYPE_TIMESTAMP, // 7
        MYSQL_TYPE_LONGLONG, // 8
        MYSQL_TYPE_INT24, // 9
        MYSQL_TYPE_DATE, // 10
        MYSQL_TYPE_TIME, // 11
        MYSQL_TYPE_DATETIME, // 12
        MYSQL_TYPE_YEAR, // 13
        MYSQL_TYPE_NEWDATE, // 14
        MYSQL_TYPE_VARCHAR, // 15
        MYSQL_TYPE_BIT, // 16
        MYSQL_TYPE_TIMESTAMP2, // 17
        MYSQL_TYPE_DATETIME2, // 18
        MYSQL_TYPE_TIME2, // 19
        MYSQL_TYPE_JSON=245,
        MYSQL_TYPE_NEWDECIMAL=246,
        MYSQL_TYPE_ENUM=247,
        MYSQL_TYPE_SET=248,
        MYSQL_TYPE_TINY_BLOB=249,
        MYSQL_TYPE_MEDIUM_BLOB=250,
        MYSQL_TYPE_LONG_BLOB=251,
        MYSQL_TYPE_BLOB=252,
        MYSQL_TYPE_VAR_STRING=253,
        MYSQL_TYPE_STRING=254,
        MYSQL_TYPE_GEOMETRY=255
        */
        switch (mysqlType) {
            case 0:   return Types.DECIMAL;
            case 1:   return Types.SMALLINT;
            case 2:   return Types.SMALLINT;
            case 3:   return Types.BIGINT;
            case 4:   return Types.FLOAT;
            case 5:   return Types.DOUBLE;
            case 6:   return Types.NULL;
            case 7:   return Types.TIMESTAMP;
            case 8:   return Types.BIGINT;
            case 9:   return Types.INTEGER;
            case 10:  return Types.DATE;
            case 11:  return Types.TIME;
            case 12:  return Types.TIMESTAMP;
            case 13:  return Types.INTEGER;
            case 14:  return Types.DATE;
            case 15:  return Types.VARCHAR;
            case 16:  return Types.BIT;
            case 17:  return Types.TIMESTAMP;
            case 18:  return Types.TIMESTAMP;
            case 19:  return Types.TIME;
            case 245: return Types.OTHER;
            case 246: return Types.DECIMAL;
            case 247: return Types.CHAR;
            case 248: return Types.CHAR;
            case 249: return Types.BLOB;
            case 250: return Types.BLOB;
            case 251: return Types.BLOB;
            case 252: return Types.BLOB;
            case 253: return Types.VARCHAR;
            case 254: return Types.CHAR;
            case 255: return Types.OTHER;
        }
        return Types.OTHER;
    }

    public static String mysqlCharsetNumToName(int mysqlCharsetNum) {
        // These values live in mysql src at strings/ctype*.c in CHARSET_INFO
        // structs. We can generate the following switch statement like so:
        //
        // ```
        // mysql -e 'show collation' -BN | \
        //   awk '{print "case " $3 ": return \"" $2 "\";"}' | \
        //   sort -V
        // ```
        switch (mysqlCharsetNum) {
            case 1: return "big5";
            case 2: return "latin2";
            case 3: return "dec8";
            case 4: return "cp850";
            case 5: return "latin1";
            case 6: return "hp8";
            case 7: return "koi8r";
            case 8: return "latin1";
            case 9: return "latin2";
            case 10: return "swe7";
            case 11: return "ascii";
            case 12: return "ujis";
            case 13: return "sjis";
            case 14: return "cp1251";
            case 15: return "latin1";
            case 16: return "hebrew";
            case 18: return "tis620";
            case 19: return "euckr";
            case 20: return "latin7";
            case 21: return "latin2";
            case 22: return "koi8u";
            case 23: return "cp1251";
            case 24: return "gb2312";
            case 25: return "greek";
            case 26: return "cp1250";
            case 27: return "latin2";
            case 28: return "gbk";
            case 29: return "cp1257";
            case 30: return "latin5";
            case 31: return "latin1";
            case 32: return "armscii8";
            case 33: return "utf8";
            case 34: return "cp1250";
            case 35: return "ucs2";
            case 36: return "cp866";
            case 37: return "keybcs2";
            case 38: return "macce";
            case 39: return "macroman";
            case 40: return "cp852";
            case 41: return "latin7";
            case 42: return "latin7";
            case 43: return "macce";
            case 44: return "cp1250";
            case 45: return "utf8mb4";
            case 46: return "utf8mb4";
            case 47: return "latin1";
            case 48: return "latin1";
            case 49: return "latin1";
            case 50: return "cp1251";
            case 51: return "cp1251";
            case 52: return "cp1251";
            case 53: return "macroman";
            case 54: return "utf16";
            case 55: return "utf16";
            case 56: return "utf16le";
            case 57: return "cp1256";
            case 58: return "cp1257";
            case 59: return "cp1257";
            case 60: return "utf32";
            case 61: return "utf32";
            case 62: return "utf16le";
            case 63: return "binary";
            case 64: return "armscii8";
            case 65: return "ascii";
            case 66: return "cp1250";
            case 67: return "cp1256";
            case 68: return "cp866";
            case 69: return "dec8";
            case 70: return "greek";
            case 71: return "hebrew";
            case 72: return "hp8";
            case 73: return "keybcs2";
            case 74: return "koi8r";
            case 75: return "koi8u";
            case 77: return "latin2";
            case 78: return "latin5";
            case 79: return "latin7";
            case 80: return "cp850";
            case 81: return "cp852";
            case 82: return "swe7";
            case 83: return "utf8";
            case 84: return "big5";
            case 85: return "euckr";
            case 86: return "gb2312";
            case 87: return "gbk";
            case 88: return "sjis";
            case 89: return "tis620";
            case 90: return "ucs2";
            case 91: return "ujis";
            case 92: return "geostd8";
            case 93: return "geostd8";
            case 94: return "latin1";
            case 95: return "cp932";
            case 96: return "cp932";
            case 97: return "eucjpms";
            case 98: return "eucjpms";
            case 99: return "cp1250";
            case 101: return "utf16";
            case 102: return "utf16";
            case 103: return "utf16";
            case 104: return "utf16";
            case 105: return "utf16";
            case 106: return "utf16";
            case 107: return "utf16";
            case 108: return "utf16";
            case 109: return "utf16";
            case 110: return "utf16";
            case 111: return "utf16";
            case 112: return "utf16";
            case 113: return "utf16";
            case 114: return "utf16";
            case 115: return "utf16";
            case 116: return "utf16";
            case 117: return "utf16";
            case 118: return "utf16";
            case 119: return "utf16";
            case 120: return "utf16";
            case 121: return "utf16";
            case 122: return "utf16";
            case 123: return "utf16";
            case 124: return "utf16";
            case 128: return "ucs2";
            case 129: return "ucs2";
            case 130: return "ucs2";
            case 131: return "ucs2";
            case 132: return "ucs2";
            case 133: return "ucs2";
            case 134: return "ucs2";
            case 135: return "ucs2";
            case 136: return "ucs2";
            case 137: return "ucs2";
            case 138: return "ucs2";
            case 139: return "ucs2";
            case 140: return "ucs2";
            case 141: return "ucs2";
            case 142: return "ucs2";
            case 143: return "ucs2";
            case 144: return "ucs2";
            case 145: return "ucs2";
            case 146: return "ucs2";
            case 147: return "ucs2";
            case 148: return "ucs2";
            case 149: return "ucs2";
            case 150: return "ucs2";
            case 151: return "ucs2";
            case 159: return "ucs2";
            case 160: return "utf32";
            case 161: return "utf32";
            case 162: return "utf32";
            case 163: return "utf32";
            case 164: return "utf32";
            case 165: return "utf32";
            case 166: return "utf32";
            case 167: return "utf32";
            case 168: return "utf32";
            case 169: return "utf32";
            case 170: return "utf32";
            case 171: return "utf32";
            case 172: return "utf32";
            case 173: return "utf32";
            case 174: return "utf32";
            case 175: return "utf32";
            case 176: return "utf32";
            case 177: return "utf32";
            case 178: return "utf32";
            case 179: return "utf32";
            case 180: return "utf32";
            case 181: return "utf32";
            case 182: return "utf32";
            case 183: return "utf32";
            case 192: return "utf8";
            case 193: return "utf8";
            case 194: return "utf8";
            case 195: return "utf8";
            case 196: return "utf8";
            case 197: return "utf8";
            case 198: return "utf8";
            case 199: return "utf8";
            case 200: return "utf8";
            case 201: return "utf8";
            case 202: return "utf8";
            case 203: return "utf8";
            case 204: return "utf8";
            case 205: return "utf8";
            case 206: return "utf8";
            case 207: return "utf8";
            case 208: return "utf8";
            case 209: return "utf8";
            case 210: return "utf8";
            case 211: return "utf8";
            case 212: return "utf8";
            case 213: return "utf8";
            case 214: return "utf8";
            case 215: return "utf8";
            case 223: return "utf8";
            case 224: return "utf8mb4";
            case 225: return "utf8mb4";
            case 226: return "utf8mb4";
            case 227: return "utf8mb4";
            case 228: return "utf8mb4";
            case 229: return "utf8mb4";
            case 230: return "utf8mb4";
            case 231: return "utf8mb4";
            case 232: return "utf8mb4";
            case 233: return "utf8mb4";
            case 234: return "utf8mb4";
            case 235: return "utf8mb4";
            case 236: return "utf8mb4";
            case 237: return "utf8mb4";
            case 238: return "utf8mb4";
            case 239: return "utf8mb4";
            case 240: return "utf8mb4";
            case 241: return "utf8mb4";
            case 242: return "utf8mb4";
            case 243: return "utf8mb4";
            case 244: return "utf8mb4";
            case 245: return "utf8mb4";
            case 246: return "utf8mb4";
            case 247: return "utf8mb4";
        }
        return null;
    }
}

package com.envisioniot.example.sample.tsdbpolicy.v2_1;

public class Point {
    private final String pointId;
    private Sdt sdt;
    private Db db;

    public Point(String pointId) {
        this.pointId = pointId;
    }

    public void setSdt(Sdt sdt) {
        this.sdt = sdt;
    }

    public void setDb(Db db) {
        this.db = db;
    }

    public String getPointId() {
        return pointId;
    }

    public Sdt getSdt() {
        return sdt;
    }

    public Db getDb() {
        return db;
    }

    public static class Sdt {
        private final float compdev;
        private final int compmax;
        private final int compmin;

        public Sdt(float compdev, int compmax, int compmin) {
            this.compdev = compdev;
            this.compmax = compmax;
            this.compmin = compmin;
        }

        public float getCompdev() {
            return compdev;
        }

        public int getCompmax() {
            return compmax;
        }

        public int getCompmin() {
            return compmin;
        }
    }

    public static class Db {
        private final float excdev;
        private final int excmax;
        private final int excmin;

        public Db(float excdev, int excmax, int excmin) {
            this.excdev = excdev;
            this.excmax = excmax;
            this.excmin = excmin;
        }

        public float getExcdev() {
            return excdev;
        }

        public int getExcmax() {
            return excmax;
        }

        public int getExcmin() {
            return excmin;
        }
    }

}

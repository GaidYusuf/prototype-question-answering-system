import static java.lang.Math.sqrt;

public class Vector {
    private double[] doubElements;

    public Vector(double[] _elements) {
        //TODO Task 1.1
        this.doubElements = _elements;
    }

    public double getElementatIndex(int _index) {
        //TODO Task 1.2

       //length of array
       int length = doubElements.length;
        //System.out.println(length);

        //if index is out of bounds
        if (_index >= length || _index < 0) {
            return -1;
        } else {
            return doubElements[_index];
        }
    }

    public void setElementatIndex(double _value, int _index) {
        //TODO Task 1.3

        //length of array
        int length = doubElements.length;

        if (_index >= 0 && _index >= length) {
            doubElements[length - 1] = _value;
        } else {
            doubElements[_index] = _value;
        }
    }

    public double[] getAllElements() {
        //TODO Task 1.4
        return doubElements;
    }

    public int getVectorSize() {
        //TODO Task 1.5

        //size of array
        int size = doubElements.length;
        return size;
    }

    public Vector reSize(int _size) {
        //TODO Task 1.6
        //length of vector
        int length = doubElements.length;

        if (_size != length && _size > 0) {
            double[] myVector = new double[_size];          //creating a new array 'myVector'
            if (_size < length) {
                for (int i = 0; i < _size; i++) {
                    myVector[i] = doubElements[i];
                }
            } else {
                for (int i = 0; i < length; i++) {
                    myVector[i] = doubElements[i];
                }
                for (int j = length; j < _size; j++) {
                    myVector[j] = -1;
                }
            }
            return new Vector(myVector);
        } else {
            return new Vector(doubElements);
        }
    }

    public Vector add(Vector _v) {
        //TODO Task 1.7

        //length of current vector
        int length = doubElements.length;

        //length of vector _v
        int lengthV = _v.getVectorSize();

        if (length > lengthV) {
            _v = _v.reSize(getVectorSize());    //calling reSize method
        } else {
            reSize(lengthV);                    //calling reSize method
        }
        double[] myVector = new double[_v.getVectorSize()];
        for (int i = 0; i < _v.getVectorSize(); i++) {
            myVector[i] = getElementatIndex(i) + _v.getElementatIndex(i);
        }
        return new Vector(myVector);

    }

    public Vector subtraction(Vector _v) {
        //TODO Task 1.8
        //length of current vector
        int length = doubElements.length;

        //length of vector _v
        int lengthV = _v.getVectorSize();

        if (length > lengthV) {
            _v = _v.reSize(getVectorSize());    //calling reSize method
        } else {
            reSize(lengthV);                    //calling reSize method
        }
        double[] myVector = new double[_v.getVectorSize()];
        for (int i = 0; i < _v.getVectorSize(); i++) {
            myVector[i] =  getElementatIndex(i) - _v.getElementatIndex(i);
        }
        return new Vector(myVector);
    }

    public double dotProduct(Vector _v) {
        //TODO Task 1.9
        double result = 0;

        //length of current vector
        int length = doubElements.length;

        //length of vector _v
        int lengthV = _v.getVectorSize();

        if (length > lengthV) {
            _v = _v.reSize(getVectorSize());    //calling reSize method
        } else {
            reSize(lengthV);                    //calling reSize method
        }
        double[] myVector = new double[_v.getVectorSize()];
        for (int i = 0; i < _v.getVectorSize(); i++) {
            myVector[i] =  getElementatIndex(i) * _v.getElementatIndex(i);
            result += myVector[i];
        }
        return result;
    }

    public double cosineSimilarity(Vector _v) {
        //TODO Task 1.10
        //length of current vector
        int length = doubElements.length;

        //length of vector _v
        int lengthV = _v.getVectorSize();

        if (length > lengthV) {
            _v = _v.reSize(getVectorSize());    //calling reSize method
        } else {
            reSize(lengthV);                    //calling reSize method
        }

        double dproduct = this.dotProduct(_v);
        //System.out.println(dproduct);
        double ulen = 0;    double vlen = 0;

        for (int i = 0; i < _v.getVectorSize(); i++) {
            //System.out.println(this.getElementatIndex(i));
            ulen += (this.getElementatIndex(i) * this.getElementatIndex(i));
            //System.out.println(_v.getElementatIndex(i));
            vlen += (_v.getElementatIndex(i) * _v.getElementatIndex(i));
        }
        return (dproduct / (sqrt(ulen) * sqrt(vlen)));
    }

    @Override
    public boolean equals(Object _obj) {
        Vector v = (Vector) _obj;
        boolean boolEquals = true;
        //TODO Task 1.11

        if (v.getVectorSize() != doubElements.length) {
            boolEquals = false;
        } else {
            for (int i = 0; i < v.getVectorSize(); i++) {
                if (v.getElementatIndex(i) != doubElements[i]) {
                    boolEquals = false;
                }
            }
        }
        return boolEquals;
    }

    @Override
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < this.getVectorSize(); i++) {
            mySB.append(String.format("%.5f", doubElements[i])).append(",");
        }
        mySB.delete(mySB.length() - 1, mySB.length());
        return mySB.toString();
    }
}

import java.math.BigInteger;
import java.util.ArrayList;

class RivestShamirAdleman
{
    private Primes primeNum = new Primes();
    private long n = -1;
    private long e = -1;

    public ArrayList<String> Encode(String text)
    {
        ArrayList<String> result = new ArrayList<String>();
        int p = primeNum.GetPrime();
        int q = primeNum.GetPrime();
        BigInteger c;

        if (p == q)
            while(p == q)
                q = primeNum.GetPrime();

        n = p * q;

        long m = (p - 1) * (q - 1);
        e = CalcE(m);

        long d = CalcD(e, m);

        for (int i = 0; i < text.length(); i++)
        {
            int index = text.charAt(i);

            c = new BigInteger(Integer.toString(index));
            c = c.modPow(new BigInteger(Long.toString(d)), new BigInteger(Long.toString(n)));

            result.add(c.toString());
        }

        return result;
    }

    public String Decode(ArrayList<String> input)
    {
        String result = "";
        BigInteger m;

        if (e > 0 && n > 0)
        {
            for (int i = 0; i < input.size(); i++)
            {
                m = new BigInteger(input.get(i));

                m = m.modPow(new BigInteger(Long.toString(e)), new BigInteger(Long.toString(n)));

                int index = m.intValue();
                result += (char) index;
            }
        }

        return result;
    }
    //вычисляем взаимнопростое число
    private long CalcE(long m)
    {
        long d = m - 1;

        for (long i = 2; i <= m; i++)
        {
            if (m % i == 0 && d % i == 0)
            {
                d--;
                i = 1;
            }
        }

        return d;
    }
    //вычисляем обратномультиплекативное число числу е
    private long CalcD(long d, long m)
    {
        long e = 10;

        while (true)
        {
            if ((e * d) % m == 1)
                break;
            else
                e++;
        }

        return e;
    }
}

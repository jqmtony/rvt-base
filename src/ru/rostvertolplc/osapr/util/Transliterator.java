package ru.rostvertolplc.osapr.util;

/**
 * <p>Title: Transliterator</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: LANIT</p>
 * @SIMiX
 * @version 1.0
 */

public class Transliterator
{
  static String ARus =
   "ÀÁÂÃÄÅ¨ÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞßàáâãäå¸æçèéêëìíîïğñòóôõö÷øùúûüışÿ\\/";
  //static String ALat[] =
  //{"A","B","V","G","D","E","JO","ZH","Z","I","J","K","L","M","N","O","P","R","S","T","U","F","H","C","CH","SH","SC","'","Y","","E","JU","JA",
  // "a","b","v","g","d","e","jo","zh","z","i","j","k","l","m","n","o","p","r","s","t","u","f","h","c","ch","sh","sc","'","y","","e","ju","ja","^","^"};

  // -- ïî ÃÎÑÒ 7.79-2000 (ÈÑÎ 9-95)
  // http://gsnti-norms.ru/norms/common/doc.asp?2&/norms/stands/7_79.htm
  static String ALat[] =
  {"A","B","V","G","D","E","YO","ZH","Z","I","J","K","L","M","N","O","P","R","S","T","U","F","X","C","CH","SH","SHH","'","Y","`","E","YU","YA",
   "a","b","v","g","d","e","yo","zh","z","i","j","k","l","m","n","o","p","r","s","t","u","f","x","c","ch","sh","shh","'","y","`","e","yu","ya","^","^"};

  public Transliterator()
  {
  }

  public static String Decode_RUS_LAT(String sRus)
  {
    int i,n, j;
    StringBuffer Result= new StringBuffer();
    n=sRus.length();
    for (i=0; i<n; i++)
    {
      char ch = sRus.charAt(i);
      j = ARus.indexOf(ch);
      if (j>=0) Result.append(ALat[j]);
      else Result.append(ch);
    }
    return Result.toString();
  }

}


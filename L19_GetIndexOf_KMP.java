// KMP - names of three persons

// find substr (m) in the string (s)
public static int getIndexOf(String s, String m) {
  if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
    return -1;
  }
  char[] str1 = s.toCharArray();
  char[] str2 = m.toCharArray();   //sub string
  int i1 = 0;
  int i2 = 0;
  int[] next = getNextArray(str2);
  while (i1 < str1.length && i2 < str2.length) {
    if (str1[i1] == str2[i2]) {
      i1++;  i2++;
    } else if (next[i2] == -1) {
      i1++;
    } else {
      i2 = next[i2];
    }
  }
  // when i2 == str2.length : i2 is moved to the end of str2
  // that is, the match is found, at starting index (i1-i2) in str1
  return i2 == str2.length ? i1-i2 : -1;
}

// take str2 input. find cn for each i
// 0           i
// |----   ----|      str2[0 : cn-1] = str2[i-cn : i-1] 
//      cn
public static int[] getNextArray(char[] str) {
  if (str.length == 1) {
    return new int[] { -1 };
  } 
  int[] next = new int[str.length];
  next[0] = -1;
  next[1] = 0;
  int i = 2;
  int cn = 0;
  while (i < next.length) {
    if (str[i-1] == str[cn]) {
      next[i++] = ++cn;
    } else if (cn > 0) {
      cn = next[cn];   // find the match in str2[ 0: next[cn]]
    } else {
      next[i++] = 0;
    }
  }
  return next;
}

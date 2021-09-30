//Unique Email Addresses
public class Day27 {

    /*
    Approach 1: Use HashSet, since in Set there are only unique data
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String localName = email.split("@")[0];
            String domainName = email.split("@")[1];

            localName = localName.replace(".", "");
            int idx = localName.indexOf('+');
            if (idx != -1) {
                localName = localName.substring(0, idx);
            }

            set.add(localName + "@" + domainName);
        }

        return set.size();
    }


    /*
    Approach 2: Hashset with Stringbuilder
     */
    public int numUniqueEmails2(String[] emails) {
        Set<String> emailsSet = new HashSet<>();

        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e.length(); i++) {
                if (e.charAt(i) == '.') {
                    continue;
                } else if (e.charAt(i) == '+') {
                    int idx = e.length() - 1;
                    while (e.charAt(idx) != '@') {
                        idx--;
                    }
                    sb.append(e.substring(idx));
                    break;
                } else {
                    sb.append(e.charAt(i));
                }
            }
            emailsSet.add(sb.toString());
        }

        return emailsSet.size();
    }


    //Stupid Approach
    public int numUniqueEmails3(String[] emails) {

        List<String> list = new ArrayList<>();

        label:
        for (String x : emails) {
            int index = x.indexOf("@");
            String domain = x.substring(index);
            char[] address = x.substring(0, index).toCharArray();

            String add = "";

            for (char y : address) {
                if (y == '.')
                    continue;
                if (y == '+')
                    break;
                add += y;
            }
            add += domain;

            boolean dub = false;
            for (String name : list) {
                if (add.equals(name))
                    dub = true;
            }
            if (!dub)
                list.add(add);
        }
        return list.size();
    }


}

public class Main{
    public static void main(String[] args){

        String str = "VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAGSDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQFZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGABDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRLYVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH";
        str = str + "ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBUXFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLRZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPGMHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPAVIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF";
        str = str + "GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJCEKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASKPEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWWCGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZPRWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS";
        str = str + "PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMRJNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECLYZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLPHBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLNDQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF";
        str = str + "LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYWCZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQIYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYIZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZBHGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP";
        str = str + "FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEASVJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJBMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSRRRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVYABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX";
        

        char[] ch = str.toCharArray();
        String[][] all = new String[30][50];
        int n = 0;
        int res = 0;

        //将所有字母添加到二维数组all中
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 50; j++){

                //将char型转换成string型并添加进二维数组all中
                all[i][j] = String.valueOf(ch[n]);
                n++;
            }
        }

        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 50; j++){
                //从左到右横向对比字母是否比前位大
                for(int x = j; x < 50; x++){
                    if(all[i][x].compareTo(all[i][j]) > 0)
                        res++;
                }

                //从上到下纵向对比字母是否比前位大
                for(int y = i; y < 30; y++){
                    if(all[y][j].compareTo(all[i][j]) > 0)
                        res++;
                }
                //从左上到右下斜向对比字母是否比前位大
                for(int x = j, y = i; x < 50 && y < 30; x++,y++){
                    if(all[y][x].compareTo(all[i][j]) > 0)
                        res++;
                }

                //从左下到右上斜向对比字母是否比前位大
                for(int x = j, y = i; x >= 0 && y < 30; x--,y++){
                    if(all[y][x].compareTo(all[i][j]) > 0)
                        res++;
                }
                //从右上到左下斜向对比字母是否比前位大
                for(int x = j, y = i; x < 50 && y >= 0; x++,y--){
                    if(all[y][x].compareTo(all[i][j]) > 0)
                        res++;
                }
            }
        }

        System.out.println(res);
    }
}
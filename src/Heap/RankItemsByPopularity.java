package Heap;

import java.util.ArrayList;
import java.util.*;


class ProductItem implements Comparable<ProductItem>{

    int productId;
    int popularityScore;
    int price;

    ProductItem(int id, int score, int price) {
        this.productId = id;
        this.popularityScore = score;
        this.price = price;
    }

    public int compareTo(ProductItem p) {
        return this.popularityScore - p.popularityScore;
    }


}

class PriceComparator implements Comparator<ProductItem> {

    public int compare(ProductItem p1, ProductItem p2) {
        if(p1.price < p2.price) {
            return -1;
        } else
        if(p1.price > p2.price) {
            return 1;
        }
        return 0;
    }
}

class RankComparator implements Comparator<ProductItem> {

    public int compare(ProductItem p1, ProductItem p2) {
        if(p1.popularityScore < p2.popularityScore) {
            return -1;
        } else
        if(p1.popularityScore > p2.popularityScore) {
            return 1;
        }
        return 0;
    }
}

public class RankItemsByPopularity  {
    public static void main(String args[]) {

        List<ProductItem> lstProducts = new ArrayList<ProductItem>();
        ProductItem p1 = new ProductItem(2,1,5);
        ProductItem p2 = new ProductItem(1,2,7);
        ProductItem p3 = new ProductItem(4,3,10);
        ProductItem p4 = new ProductItem(3,4,8);
        ProductItem p5 = new ProductItem(5,4,2);
        ProductItem p6 = new ProductItem(7,4,7);
        ProductItem p7 = new ProductItem(6,4,10);
        lstProducts.add(p1);
        lstProducts.add(p2);
        lstProducts.add(p3);
        lstProducts.add(p4);
        lstProducts.add(p5);
        lstProducts.add(p6);
        lstProducts.add(p7);
        //113
        RankComparator rankCompare = new RankComparator();
        PriceComparator priceCompare = new PriceComparator();
        Collections.sort(lstProducts,new RankComparator().thenComparing(new PriceComparator()));
       // Collections.sort(lstProducts,priceCompare);
        for(ProductItem p : lstProducts) {
            System.out.println(p.productId);
        }

    }

}

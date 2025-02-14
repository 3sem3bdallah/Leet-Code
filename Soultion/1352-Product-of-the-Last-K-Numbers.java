class ProductOfNumbers {
    private ArrayList<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1); // Initialize with 1 to handle the first product calculation
    }
    
    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1); // Reset to handle the case when num is 0
        } else {
            products.add(num * products.get(products.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        if (k >= products.size()) {
            return 0; // If k is greater than or equal to the size, return 0
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

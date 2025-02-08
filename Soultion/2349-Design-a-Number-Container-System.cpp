class NumberContainers {
public:
    unordered_map<int, int> indexToNumber;
    unordered_map<int, set<int>> numberToIndices;

    NumberContainers() {
    }

    void change(int index, int number) {
        if (indexToNumber.count(index)) {
            int oldNumber = indexToNumber[index];
            numberToIndices[oldNumber].erase(index);
        }
        indexToNumber[index] = number;
        numberToIndices[number].insert(index);
    }

    int find(int number) {
        if (numberToIndices[number].empty()) {
            return -1;
        }
        return *numberToIndices[number].begin();
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */

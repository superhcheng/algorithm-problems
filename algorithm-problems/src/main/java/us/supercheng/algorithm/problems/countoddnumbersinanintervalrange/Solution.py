class Solution:
    def countOdds(self, low: int, high: int) -> int:
        '''
        3 4 5 6 7 8 9 10> 10 - 3 + 1 = 8    4
        3 4 5 6 7 8 9   > 9 - 3 + 1 = 7     4
        3 4 5 6 7 8     > 8 - 3 + 1 = 6     3
        3 4 5 6 7       > 7 - 3 + 1 = 5     3
        3 4 5 6         > 6 - 3 + 1 = 4     2
        3 4 5           > 5 - 3 + 1 = 3     2
        4 5 6           > 6 - 4 + 1 = 3     1
        4 5 6 7         > 7 - 4 + 1 = 4     2
        4 5 6 7 8       > 8 - 4 + 1 = 5     2
        4 5 6 7 8 9     > 9 - 4 + 1 = 6     3
        4 5 6 7 8 9 10  > 10 - 4 + 1 = 7    3
        '''
        return (high - low + 1) // 2 + 1 if low % 2 != 0 and high % 2 != 0 else (high - low + 1) // 2
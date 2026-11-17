class Solution:
    def minMaxWaitingTime(self, demand: List[int], fuel: List[int]) -> int:
        n = len(demand)

        def max_cars_possible(W: int) -> int:
            dp = {(0, 0, 0)}

            for i in range(n):
                new_dp = set()
                dem = demand[i]
                f1_total = sum(demand[:i])

                for f0, d0, d1 in dp:
                    f1 = f1_total - f0
                    rem0 = fuel[0] - f0
                    rem1 = fuel[1] - f1

                    if rem0 >= dem and d0 <= W:
                        new_f0 = f0 + dem
                        new_d0 = dem
                        new_d1 = max(0, d1 - d0)
                        if new_f0 <= fuel[0]:
                            new_dp.add((new_f0, new_d0, new_d1))

                    if rem1 >= dem and d1 <= W:
                        new_f0 = f0
                        new_d0 = max(0, d0 - d1)
                        new_d1 = dem
                        if f1 + dem <= fuel[1]:
                            new_dp.add((new_f0, new_d0, new_d1))

                if not new_dp:
                    return i

                dp = new_dp

            return n

        K = max_cars_possible(20)

        if K == 0:
            return -1

        left = 0
        right = 20
        ans = 20

        while left <= right:
            mid = (left + right) // 2

            if max_cars_possible(mid) == K:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1

        return ans
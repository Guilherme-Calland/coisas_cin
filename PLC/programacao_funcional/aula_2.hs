fat :: Int -> Int
fat n
 | n == 0 = 1
 | otherwise = n*fat(n-1)

all4Equal :: Int -> Int -> Int -> Int -> Bool
all4Equal a b c d
 | a == b && a == c && a == d = True
 | otherwise = False

equalCount :: Int-> Int -> Int -> Int
equalCount a b c
 | a == b && a == c = 3
 | a == b || b == c || a == c = 2
 | otherwise = 0
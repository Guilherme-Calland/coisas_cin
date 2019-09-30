-- aula 11
-- I/O entrada e saída, the old in-out

-- :t getLine
-- :t putStrLn
-- getLine
-- aaaaaa
-- putStrLn "asdas"

-- l <- getLine
-- putStrLn l

-- imprimeInvertida :: IO()
-- imprimeInvertida =  do
--     l1 <- getLine
--     l2 <- getLine
--     putStrLn (reverse l2)
--     putStrLn (reverse l1)
-- anotacao 'do' faz: -  realizar a sequencia de ações conforme for escrito

-- impr :: IO ()
-- impr = getLine >>=(\ -> putStrLn (reverse x)) -- essas anotações estranhas nao sao importantes



-- main = do 
--     l <- getLine
--     putStrLn l

--sai do ghci
    -- ghc aula_11.hs -o aula_11
    -- ./aula_11

-- main = do
--     return ()
--     l1 <- return "hahaha"
--     line <- getLine
--     return "blablabla"
--     putStrLn line
--     putStrLn l1

-- main = do 
--     line <- getLine
--     if null line
--     then return ()
--     else (do
--         putStrLn $ reverseWords line
--         main) -- > esse main do final faz a funcao entrar em loop
    
reverseWords :: String -> String
reverseWords = unwords . map reverse . words

-- no ghci
-- words "dasdas"
--unwords ["dasdasds"]
-- map reverse ()
-- words

-- $ ->  a primeira coisa que vamos fazer é avaliar oq está a direita do $
-- teria o mesmo efeito fazer putStrLn (reverseWords line)

-- main = do
--     a <- return "oi"
--     b <- return "tchau"
--     putStrLn ( a ++ " " ++ b ) 

-- f = do
--     line <- getLine

showStackHead [] = return []
showStackHead (x:xs) = do
    putStrLn $ "resultado " ++ [x]
    return xs

main :: IO()
main = do
    let s1 = []
    r1 <- showStackHead s1
    putStrLn $ "retornou " ++ r1

    putStrLn " --- "

    let s2 = "asdf"
    r2 <- showStackHead s2
    putStrLn $ "retornou " ++ r2

    putStrLn " --- "

    let s3 = "q"
    r3 <- showStackHead s3
    putStrLn $ "retornou " ++ r3



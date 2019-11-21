import Control.Concurrent

--primeiro exemplo
main = do

    -- cria uma MVar que inicialmente é vazia
    m <- newEmptyMVar

    -- putMVar colocar um valor numa MVar
    --se estiver cheia esperará até ficar vazia
    forkIO $ putMVar m 'x'

    --takeMvar pega um valor do MVar
    --se ela estiver vazia vai esperar até que ela fique cheia
    r <- takeMVar m

    print r

--com mvar
main2 = do
    m <- newEmptyMVar

    forkIO $ putMVar m "Hello Haskell"
    forkIO $ putMVar m "Hello Mvar"

    r <- takeMVar m
    print r
    r <- takeMVar m
    print r
    print "fim"

--sem mvar
main3 = do
    let msg1 = "Hello Haskell"
    let msg2 = "Hello MVar"

    forkIO $ print msg1
    forkIO $ print msg2
    print "Fim"
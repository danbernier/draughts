./jar.sh

rm -rf build
mkdir -p build/draughts/library
mkdir -p build/draughts/src

cp draughts.jar build/draughts/library
cp -r src/ build/draughts/

cd build

cp draughts -r ~/projects/p5j3/libraries

cd ..

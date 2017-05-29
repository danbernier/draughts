./jar.sh

rm -rf build
mkdir -p build/draughts/library
mkdir -p build/draughts/src

mv draughts.jar build/draughts/library
cp -r src/ build/draughts/

cd build

# linux:
# cp draughts -r ~/projects/p5j3/libraries
# mac:
cp -r draughts ~/projects/p5j3/libraries

cd ..

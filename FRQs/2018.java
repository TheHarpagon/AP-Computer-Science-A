// https://secure-media.collegeboard.org/apc/ap18-frq-computer-science-a.pdf

// 1A
public boolean simulate() {
  int distance = 0;
  int hops = 0;
  while (hops < maxHops) {
    distance += hopDistance();
    hops++;
  }
  return (distance >= goalDistance) ? true : false;
}

// 1B
public double runSimulations(int num) {
  int valid = 0;
  for (int i = 0; i < num; i++) {
    if (simulate())
			valid++;
  }
  return (double) valid / num;
}

// did not do 2
// did not do 3
// did not do 4
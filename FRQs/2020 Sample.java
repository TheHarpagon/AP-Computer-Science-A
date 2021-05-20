// https://apcentral.collegeboard.org/pdf/ap-2020exam-sample-questions-computer-science.pdf

// 1A
public int countElectronicByMaker(String maker) {
	int count = 0;
	for (Gizmo i : purchases) {
		if (i.isElectronic() && i.getMaker().equals(maker))
			count++;
	}
	return count;
}

// 1B
public boolean hasAdjacentEqualPair() {
	for (int i = 0; i < purchases.size() - 1; i++) {
		if (purchases.get(i).equals(purchases.get(i + 1)))
			return true;
	}
	return false;
}

// did not do 1C
// did not do 2
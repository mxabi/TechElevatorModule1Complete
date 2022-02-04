using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Exercises.Tests
{
    [TestClass]
    public class WeekendTests
    {
        Exercises exercises = new Exercises();

        /*
         ArrayCount9([1, 2, 9]) → 1
         ArrayCount9([1, 9, 9]) → 2
         ArrayCount9([1, 9, 9, 3, 9]) → 3
         */
        [TestMethod]
        public void ArrayCount9()
        {
            Assert.AreEqual(1, exercises.ArrayCount9(new int[] { 1, 2, 9 }), "Input {1, 2, 9}");
            Assert.AreEqual(2, exercises.ArrayCount9(new int[] { 1, 9, 9 }), "Input {1, 9, 9}");
            Assert.AreEqual(3, exercises.ArrayCount9(new int[] { 1, 9, 9, 3, 9 }), "Input {1, 9, 9, 3, 9}");
            Assert.AreEqual(0, exercises.ArrayCount9(new int[] { 1, 2, 3 }), "Input {1, 2, 3}");
            Assert.AreEqual(0, exercises.ArrayCount9(new int[] { }), "Input { }");
            Assert.AreEqual(0, exercises.ArrayCount9(new int[] { 4, 2, 4, 3, 1 }), "Input { 4, 2, 4, 3, 1 }");
            Assert.AreEqual(1, exercises.ArrayCount9(new int[] { 9, 2, 4, 3, 1 }), "Input { 9, 2, 4, 3, 1 }");
        }

        /*
         ArrayFront9([1, 2, 9, 3, 4]) → true
         ArrayFront9([1, 2, 3, 4, 9]) → false
         ArrayFront9([1, 2, 3, 4, 5]) → false
         */
        [TestMethod]
        public void ArrayFront9()
        {
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 1, 2, 9, 3, 4 }), "Input: {1, 2, 9, 3, 4} ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { 1, 2, 3, 4, 9 }), "Input: {1, 2, 3, 4, 9} ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { 1, 2, 3, 4, 5 }), "Input: {1, 2, 3, 4, 5} ");
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 9, 2, 3 }), "Input: {9, 2, 3} ");
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 1, 9, 9 }), "Input: {1, 9, 9} ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { 1, 2, 3 }), "Input: {1, 2, 3} ");
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 1, 9 }), "Input: {1, 9} ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { 5, 5 }), "Input: {5, 5 } ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { 2 }), "Input: { 2 } ");
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 9 }), "Input: { 9 } ");
            Assert.AreEqual(false, exercises.ArrayFront9(new int[] { }), "Input: { } ");
            Assert.AreEqual(true, exercises.ArrayFront9(new int[] { 3, 9, 2, 3, 3 }), "Input: { 3, 9, 2, 3, 3 } ");
        }

        /*
         Array123([1, 1, 2, 3, 1]) → true
         Array123([1, 1, 2, 4, 1]) → false
         Array123([1, 1, 2, 1, 2, 3]) → true
         */
        [TestMethod]
        public void Array123()
        {
            Assert.AreEqual(true, exercises.Array123(new int[] { 1, 1, 2, 3, 1 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { 1, 1, 2, 4, 1 }));
            Assert.AreEqual(true, exercises.Array123(new int[] { 1, 1, 2, 1, 2, 3 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { 1, 1, 2, 1, 2, 1 }));
            Assert.AreEqual(true, exercises.Array123(new int[] { 1, 2, 3, 1, 2, 3 }));
            Assert.AreEqual(true, exercises.Array123(new int[] { 1, 2, 3 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { 1, 1, 1 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { 1, 2 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { 1 }));
            Assert.AreEqual(false, exercises.Array123(new int[] { }));
        }

        /*
         NoTriples([1, 1, 2, 2, 1]) → true
         NoTriples([1, 1, 2, 2, 2, 1]) → false
         NoTriples([1, 1, 1, 2, 2, 2, 1]) → false
         */
        [TestMethod]
        public void NoTriples()
        {
            Assert.AreEqual(true, exercises.NoTriples(new int[] { 1, 1, 2, 2, 1 }));
            Assert.AreEqual(false, exercises.NoTriples(new int[] { 1, 1, 2, 2, 2, 1 }));
            Assert.AreEqual(false, exercises.NoTriples(new int[] { 1, 1, 1, 2, 2, 2, 1 }));
            Assert.AreEqual(true, exercises.NoTriples(new int[] { 1, 1, 2, 2, 1, 2, 1 }));
            Assert.AreEqual(true, exercises.NoTriples(new int[] { 1, 2, 1 }));
            Assert.AreEqual(false, exercises.NoTriples(new int[] { 1, 1, 1 }));
            Assert.AreEqual(true, exercises.NoTriples(new int[] { 1, 1 }));
            Assert.AreEqual(true, exercises.NoTriples(new int[] { 1 }));
            Assert.AreEqual(true, exercises.NoTriples(new int[] { }));
        }

        /*
         MakeEnds([1, 2, 3]) → [1, 3]
         MakeEnds([1, 2, 3, 4]) → [1, 4]
         MakeEnds([7, 4, 6, 2]) → [7, 2]
         */
        [TestMethod]
        public void MakeEnds()
        {
            CollectionAssert.AreEqual(new int[] { 1, 3 }, exercises.MakeEnds(new int[] { 1, 2, 3 }));
            CollectionAssert.AreEqual(new int[] { 1, 4 }, exercises.MakeEnds(new int[] { 1, 2, 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 7, 2 }, exercises.MakeEnds(new int[] { 7, 4, 6, 2 }));
            CollectionAssert.AreEqual(new int[] { 1, 3 }, exercises.MakeEnds(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 }));
            CollectionAssert.AreEqual(new int[] { 7, 4 }, exercises.MakeEnds(new int[] { 7, 4 }));
            CollectionAssert.AreEqual(new int[] { 7, 7 }, exercises.MakeEnds(new int[] { 7 }));
            CollectionAssert.AreEqual(new int[] { 5, 9 }, exercises.MakeEnds(new int[] { 5, 2, 9 }));
            CollectionAssert.AreEqual(new int[] { 2, 1 }, exercises.MakeEnds(new int[] { 2, 3, 4, 1 }));
        }

        /*
         Has23([2, 5]) → true
         Has23([4, 3]) → true
         Has23([4, 5]) → false
         */
        [TestMethod]
        public void Has23()
        {
            Assert.AreEqual(true, exercises.Has23(new int[] { 2, 5 }));
            Assert.AreEqual(true, exercises.Has23(new int[] { 4, 3 }));
            Assert.AreEqual(false, exercises.Has23(new int[] { 4, 5 }));
            Assert.AreEqual(true, exercises.Has23(new int[] { 2, 2 }));
            Assert.AreEqual(true, exercises.Has23(new int[] { 3, 2 }));
            Assert.AreEqual(true, exercises.Has23(new int[] { 3, 3 }));
            Assert.AreEqual(false, exercises.Has23(new int[] { 7, 7 }));
            Assert.AreEqual(true, exercises.Has23(new int[] { 3, 9 }));
            Assert.AreEqual(false, exercises.Has23(new int[] { 9, 5 }));
        }

        /*
         No23([4, 5]) → true
         No23([4, 2]) → false
         No23([3, 5]) → false
         */
        [TestMethod]
        public void No23()
        {
            Assert.AreEqual(true, exercises.No23(new int[] { 4, 5 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 4, 2 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 3, 5 }));
            Assert.AreEqual(true, exercises.No23(new int[] { 1, 9 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 2, 9 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 1, 3 }));
            Assert.AreEqual(true, exercises.No23(new int[] { 1, 1 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 2, 2 }));
            Assert.AreEqual(false, exercises.No23(new int[] { 3, 3 }));
            Assert.AreEqual(true, exercises.No23(new int[] { 7, 8 }));
            Assert.AreEqual(true, exercises.No23(new int[] { 8, 7 }));
        }

        /*
         MakeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
         MakeLast([1, 2]) → [0, 0, 0, 2]
         MakeLast([3]) → [0, 3]
         */
        [TestMethod]
        public void MakeLast()
        {
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 0, 0, 6 }, exercises.MakeLast(new int[] { 4, 5, 6 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 2 }, exercises.MakeLast(new int[] { 1, 2 }));
            CollectionAssert.AreEqual(new int[] { 0, 3 }, exercises.MakeLast(new int[] { 3 }));
            CollectionAssert.AreEqual(new int[] { 0, 0 }, exercises.MakeLast(new int[] { 0 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 0, 0, 7 }, exercises.MakeLast(new int[] { 7, 7, 7 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 0, 0, 4 }, exercises.MakeLast(new int[] { 3, 1, 4 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 }, exercises.MakeLast(new int[] { 1, 2, 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, exercises.MakeLast(new int[] { 1, 2, 3, 0 }));
            CollectionAssert.AreEqual(new int[] { 0, 0, 0, 4 }, exercises.MakeLast(new int[] { 2, 4 }));
        }

        /*
         Double23([2, 2]) → true
         Double23([3, 3]) → true
         Double23([2, 3]) → false
         */
        [TestMethod]
        public void Double23()
        {
            Assert.AreEqual(true, exercises.Double23(new int[] { 2, 2 }));
            Assert.AreEqual(true, exercises.Double23(new int[] { 3, 3 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 2, 3 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 3, 2 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 4, 5 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 2 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 3 }));
            Assert.AreEqual(false, exercises.Double23(new int[] { }));
            Assert.AreEqual(false, exercises.Double23(new int[] { 3, 4 }));
        }

        /*
         Fix23([1, 2, 3]) → [1, 2, 0]
         Fix23([2, 3, 5]) → [2, 0, 5]
         Fix23([1, 2, 1]) → [1, 2, 1]
         */
        [TestMethod]
        public void Fix23()
        {
            CollectionAssert.AreEqual(new int[] { 1, 2, 0 }, exercises.Fix23(new int[] { 1, 2, 3 }));
            CollectionAssert.AreEqual(new int[] { 2, 0, 5 }, exercises.Fix23(new int[] { 2, 3, 5 }));
            CollectionAssert.AreEqual(new int[] { 1, 2, 1 }, exercises.Fix23(new int[] { 1, 2, 1 }));
            CollectionAssert.AreEqual(new int[] { 3, 2, 1 }, exercises.Fix23(new int[] { 3, 2, 1 }));
            CollectionAssert.AreEqual(new int[] { 2, 2, 0 }, exercises.Fix23(new int[] { 2, 2, 3 }));
            CollectionAssert.AreEqual(new int[] { 2, 0, 3 }, exercises.Fix23(new int[] { 2, 3, 3 }));
        }

        /*
         Start1([1, 2, 3], [1, 3]) → 2
         Start1([7, 2, 3], [1]) → 1
         Start1([1, 2], []) → 1
         */
        [TestMethod]
        public void Start1()
        {
            Assert.AreEqual(2, exercises.Start1(new int[] { 1, 2, 3 }, new int[] { 1, 3 }));
            Assert.AreEqual(1, exercises.Start1(new int[] { 7, 2, 3 }, new int[] { 1 }));
            Assert.AreEqual(1, exercises.Start1(new int[] { 1, 2 }, new int[] { }));
            Assert.AreEqual(1, exercises.Start1(new int[] { }, new int[] { 1, 2 }));
            Assert.AreEqual(0, exercises.Start1(new int[] { 7 }, new int[] { }));
            Assert.AreEqual(1, exercises.Start1(new int[] { 7 }, new int[] { 1 }));
            Assert.AreEqual(2, exercises.Start1(new int[] { 1 }, new int[] { 1 }));
            Assert.AreEqual(0, exercises.Start1(new int[] { 7 }, new int[] { 8 }));
            Assert.AreEqual(0, exercises.Start1(new int[] { }, new int[] { }));
            Assert.AreEqual(2, exercises.Start1(new int[] { 1, 3 }, new int[] { 1 }));
        }

        /*
         BiggerTwo([1, 2], [3, 4]) → [3, 4]
         BiggerTwo([3, 4], [1, 2]) → [3, 4]
         BiggerTwo([1, 1], [1, 2]) → [1, 2]
         */
        [TestMethod]
        public void BiggerTwo()
        {
            CollectionAssert.AreEqual(new int[] { 3, 4 }, exercises.BiggerTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 3, 4 }, exercises.BiggerTwo(new int[] { 3, 4 }, new int[] { 1, 2 }));
            CollectionAssert.AreEqual(new int[] { 1, 2 }, exercises.BiggerTwo(new int[] { 1, 1 }, new int[] { 1, 2 }));
            CollectionAssert.AreEqual(new int[] { 2, 1 }, exercises.BiggerTwo(new int[] { 2, 1 }, new int[] { 1, 1 }));
            CollectionAssert.AreEqual(new int[] { 2, 2 }, exercises.BiggerTwo(new int[] { 2, 2 }, new int[] { 1, 3 }));
            CollectionAssert.AreEqual(new int[] { 1, 3 }, exercises.BiggerTwo(new int[] { 1, 3 }, new int[] { 2, 2 }));
            CollectionAssert.AreEqual(new int[] { 6, 7 }, exercises.BiggerTwo(new int[] { 6, 7 }, new int[] { 3, 1 }));
        }

        /*
         MakeMiddle([1, 2, 3, 4]) → [2, 3]
         MakeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
         MakeMiddle([1, 2]) → [1, 2]
         */
        [TestMethod]
        public void MakeMiddle()
        {
            CollectionAssert.AreEqual(new int[] { 2, 3 }, exercises.MakeMiddle(new int[] { 1, 2, 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 2, 3 }, exercises.MakeMiddle(new int[] { 7, 1, 2, 3, 4, 9 }));
            CollectionAssert.AreEqual(new int[] { 1, 2 }, exercises.MakeMiddle(new int[] { 1, 2 }));
            CollectionAssert.AreEqual(new int[] { 2, 4 }, exercises.MakeMiddle(new int[] { 5, 2, 4, 7 }));
            CollectionAssert.AreEqual(new int[] { 4, 3 }, exercises.MakeMiddle(new int[] { 9, 0, 4, 3, 9, 1 }));
        }

        /*
         PlusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
         PlusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
         PlusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
         */
        [TestMethod]
        public void PlusTwo()
        {
            CollectionAssert.AreEqual(new int[] { 1, 2, 3, 4 }, exercises.PlusTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 4, 4, 2, 2 }, exercises.PlusTwo(new int[] { 4, 4 }, new int[] { 2, 2 }));
            CollectionAssert.AreEqual(new int[] { 9, 2, 3, 4 }, exercises.PlusTwo(new int[] { 9, 2 }, new int[] { 3, 4 }));
        }

        /*
         SwapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
         SwapEnds([1, 2, 3]) → [3, 2, 1]
         SwapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
         */
        [TestMethod]
        public void SwapEnds()
        {
            CollectionAssert.AreEqual(new int[] { 4, 2, 3, 1 }, exercises.SwapEnds(new int[] { 1, 2, 3, 4 }));
            CollectionAssert.AreEqual(new int[] { 3, 2, 1 }, exercises.SwapEnds(new int[] { 1, 2, 3 }));
            CollectionAssert.AreEqual(new int[] { 5, 6, 7, 9, 8 }, exercises.SwapEnds(new int[] { 8, 6, 7, 9, 5 }));
            CollectionAssert.AreEqual(new int[] { 9, 1, 4, 1, 5, 3 }, exercises.SwapEnds(new int[] { 3, 1, 4, 1, 5, 9 }));
            CollectionAssert.AreEqual(new int[] { 2, 1 }, exercises.SwapEnds(new int[] { 1, 2 }));
            CollectionAssert.AreEqual(new int[] { 1 }, exercises.SwapEnds(new int[] { 1 }));
        }

        /*
         More14([1, 4, 1]) → true
         More14([1, 4, 1, 4]) → false
         More14([1, 1]) → true
         */
        [TestMethod]
        public void More14()
        {
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 4, 1 }));
            Assert.AreEqual(false, exercises.More14(new int[] { 1, 4, 1, 4 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 1 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 6, 6 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1 }));
            Assert.AreEqual(false, exercises.More14(new int[] { 1, 4 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 6, 1, 1 }));
            Assert.AreEqual(false, exercises.More14(new int[] { 1, 6, 4 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 1, 4, 4, 1 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 1, 6, 4, 4, 1 }));
            Assert.AreEqual(false, exercises.More14(new int[] { }));
            Assert.AreEqual(false, exercises.More14(new int[] { 4, 1, 4, 6 }));
            Assert.AreEqual(false, exercises.More14(new int[] { 4, 1, 4, 6, 1 }));
            Assert.AreEqual(true, exercises.More14(new int[] { 1, 4, 1, 4, 1, 6 }));
        }

        /*
         FizzArray(4) → [0, 1, 2, 3]
         FizzArray(1) → [0]
         FizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
         */
        [TestMethod]
        public void FizzArray()
        {
            CollectionAssert.AreEqual(new int[] { 0, 1, 2, 3 }, exercises.FizzArray(4));
            CollectionAssert.AreEqual(new int[] { 0 }, exercises.FizzArray(1));
            CollectionAssert.AreEqual(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, exercises.FizzArray(10));
            CollectionAssert.AreEqual(new int[] { }, exercises.FizzArray(0));
            CollectionAssert.AreEqual(new int[] { 0, 1 }, exercises.FizzArray(2));
            CollectionAssert.AreEqual(new int[] { 0, 1, 2, 3, 4, 5, 6 }, exercises.FizzArray(7));
        }

        /*
         Only14([1, 4, 1, 4]) → true
         Only14([1, 4, 2, 4]) → false
         Only14([1, 1]) → true
         */
        [TestMethod]
        public void Only14()
        {
            Assert.AreEqual(true, exercises.Only14(new int[] { 1, 4, 1, 4 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 1, 4, 2, 4 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 1, 1 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 4, 1 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 2 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 1, 4, 1, 3 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 3, 1, 3 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 1 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 4 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 3, 4 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 1, 3, 4 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 1, 1, 1 }));
            Assert.AreEqual(false, exercises.Only14(new int[] { 1, 1, 1, 5 }));
            Assert.AreEqual(true, exercises.Only14(new int[] { 4, 1, 4, 1 }));
        }

        /*
         No14([1, 2, 3]) → true
         No14([1, 2, 3, 4]) → false
         No14([2, 3, 4]) → true
         */
        [TestMethod]
        public void No14()
        {
            Assert.AreEqual(true, exercises.No14(new int[] { 1, 2, 3 }), "No14(new int[]{1, 2, 3})");
            Assert.AreEqual(false, exercises.No14(new int[] { 1, 2, 3, 4 }), "No14(new int[]{1, 2, 3, 4})");
            Assert.AreEqual(true, exercises.No14(new int[] { 2, 3, 4 }), "No14(new int[]{2, 3, 4})");
        }

        /*
         Has12([1, 3, 2]) → true
         Has12([3, 1, 2]) → true
         Has12([3, 1, 4, 5, 2]) → true
         */
        [TestMethod]
        public void Has12()
        {
            Assert.AreEqual(true, exercises.Has12(new int[] { 1, 3, 2 }), "Has12(new int[]{1, 3, 2})");
            Assert.AreEqual(true, exercises.Has12(new int[] { 3, 1, 2 }), "Has12(new int[]{3, 1, 2})");
            Assert.AreEqual(true, exercises.Has12(new int[] { 3, 1, 4, 5, 2 }), "Has12(new int[]{3, 1, 4, 5, 2})");
            Assert.AreEqual(false, exercises.Has12(new int[] { 3, 2, 1 }), "Has12(new int[]{3, 2, 1})");
            Assert.AreEqual(false, exercises.Has12(new int[] { 3, 1, 4 }), "Has12(new int[]{3, 1, 4})");
            Assert.AreEqual(false, exercises.Has12(new int[] { 3, 5, 2 }), "Has12(new int[]{3, 5, 2})");
            Assert.AreEqual(false, exercises.Has12(new int[] { 5, 5, 5 }), "Has12(new int[]{5, 5, 5})");
            Assert.AreEqual(true, exercises.Has12(new int[] { 2, 1, 2 }), "Has12(new int[]{2, 1, 2})");
        }

        /*
         FizzArray3(5, 10) → [5, 6, 7, 8, 9]
         FizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
         FizzArray3(1, 3) → [1, 2]
         */
        [TestMethod]
        public void FizzArray3()
        {
            CollectionAssert.AreEqual(new int[] { 5, 6, 7, 8, 9 }, exercises.FizzArray3(5, 10), "FizzArray3(5, 10)");
            CollectionAssert.AreEqual(new int[] { 11, 12, 13, 14, 15, 16, 17 }, exercises.FizzArray3(11, 18), "FizzArray3(11, 18)");
            CollectionAssert.AreEqual(new int[] { 1, 2 }, exercises.FizzArray3(1, 3), "FizzArray3(1, 3)");
            CollectionAssert.AreEqual(new int[] { }, exercises.FizzArray3(3, 3), "FizzArray3(3, 3)");
        }

        /*
         LessBy10(1, 7, 11) → true
         LessBy10(1, 7, 10) → false
         LessBy10(11, 1, 7) → true
         */
        [TestMethod]
        public void LessBy10()
        {
            Assert.AreEqual(true, exercises.LessBy10(1, 7, 11), "LessBy10(1, 7, 11)");
            Assert.AreEqual(false, exercises.LessBy10(1, 7, 10), "LessBy10(1, 7, 10)");
            Assert.AreEqual(true, exercises.LessBy10(11, 1, 7), "LessBy10(11, 1, 7)");
            Assert.AreEqual(true, exercises.LessBy10(1, 11, 7), "LessBy10(1, 11, 7)");
            Assert.AreEqual(true, exercises.LessBy10(7, 1, 11), "LessBy10(7, 1, 11)");
            Assert.AreEqual(true, exercises.LessBy10(15, 2, 30), "LessBy10(15, 2, 30)");
        }

        /*
         GreenTicket(1, 2, 3) → 0
         GreenTicket(2, 2, 2) → 20
         GreenTicket(1, 1, 2) → 10
         */
        [TestMethod]
        public void GreenTicket()
        {
            Assert.AreEqual(0, exercises.GreenTicket(1, 2, 3), "GreenTicket(1, 2, 3)");
            Assert.AreEqual(20, exercises.GreenTicket(2, 2, 2), "GreenTicket(2, 2, 2)");
            Assert.AreEqual(10, exercises.GreenTicket(1, 1, 2), "GreenTicket(1, 1, 2)");
            Assert.AreEqual(10, exercises.GreenTicket(2, 1, 1), "GreenTicket(2, 1, 1)");
            Assert.AreEqual(10, exercises.GreenTicket(1, 2, 1), "GreenTicket(1, 2, 1)");
        }

        /*
         Blackjack(19, 21) → 21
         Blackjack(21, 19) → 21
         Blackjack(19, 22) → 19
         */
        [TestMethod]
        public void Blackjack()
        {
            Assert.AreEqual(21, exercises.Blackjack(19, 21), "Blackjack(19, 21)");
            Assert.AreEqual(21, exercises.Blackjack(21, 19), "Blackjack(21, 19)");
            Assert.AreEqual(19, exercises.Blackjack(19, 22), "Blackjack(19, 22)");
            Assert.AreEqual(19, exercises.Blackjack(22, 19), "Blackjack(22, 19)");
            Assert.AreEqual(0, exercises.Blackjack(23, 22), "Blackjack(23, 22)");
            Assert.AreEqual(0, exercises.Blackjack(23, 22), "Blackjack(10, 12)");
            Assert.AreEqual(21, exercises.Blackjack(21, 21), "Blackjack(21, 21)");
            Assert.AreEqual(17, exercises.Blackjack(17, 17), "Blackjack(17, 17)");
        }

        /*
         EvenlySpaced(2, 4, 6) → true
         EvenlySpaced(4, 6, 2) → true
         EvenlySpaced(4, 6, 3) → false
         */
        [TestMethod]
        public void EvenlySpaced()
        {
            Assert.AreEqual(true, exercises.EvenlySpaced(2, 4, 6), "EvenlySpaced(2, 4, 6)");
            Assert.AreEqual(true, exercises.EvenlySpaced(4, 6, 2), "EvenlySpaced(4, 6, 2)");
            Assert.AreEqual(false, exercises.EvenlySpaced(4, 6, 3), "EvenlySpaced(4, 6, 3)");
            Assert.AreEqual(true, exercises.EvenlySpaced(6, 2, 4), "EvenlySpaced(6, 2, 4)");
        }
    }
}
